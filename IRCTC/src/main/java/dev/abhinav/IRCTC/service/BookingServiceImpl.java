package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dao.BookingRepository;
import dev.abhinav.IRCTC.dao.TrainSeatAvailabiltyRepository;
import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.entity.Booking;
import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import dev.abhinav.IRCTC.exceptions.SeatAllocationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {

    @Value("${machine.name}")
    String machineName;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    IBookingService bookingService;

    @Autowired
    ITokenService tokenService;
    private List<BookingSetToHandle> bookingSetToHandleList;

    @Autowired
    private ISeatAllocationService seatAllocationService;
    @Autowired
    private TrainSeatAvailabiltyRepository trainSeatAvailabiltyRepository;

    @Override
    public BookingResponseDTO book(BookingRequestDTO bookingRequestDTO) throws BookingException {
        BookingResponseDTO bookingResponseDTO = null;
        AllocationDetails allocationDetails = null;
        try {
            allocationDetails = seatAllocationService.allocate(bookingRequestDTO);
        } catch (SeatAllocationException e) {
            log.error("error occured while allocating seats in booking request ", e);
            throw new BookingException("error occured while booking");
        }
        bookingResponseDTO = handlePostAllocation(allocationDetails, bookingRequestDTO);
        return bookingResponseDTO;
    }

    private BookingResponseDTO handlePostAllocation(AllocationDetails allocationDetails, BookingRequestDTO bookingRequestDTO) {

        BookingResponseDTO responseDTO = new BookingResponseDTO();
        responseDTO.setAllocatedPassengerBerth(allocationDetails.getPassengerBerthList());
        responseDTO.setPnr(allocationDetails.getPnr());
        //calculate fare now
        responseDTO.setFare(allocationDetails.getTotalFare());
        //persist the new updated availability and create new booking
        updateAvailabilityAndCreateBookingRecord(allocationDetails, bookingRequestDTO);
        return responseDTO;

    }

    private void updateAvailabilityAndCreateBookingRecord(AllocationDetails allocationDetails, BookingRequestDTO bookingRequestDTO) {
        updateAvailabilityAndCreateBookingRecord(allocationDetails.getTrainSeatsList(), bookingRequestDTO, allocationDetails.getPnr());
    }

//    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Transactional
    private void updateAvailabilityAndCreateBookingRecord(List<TrainSeat> trainSeats, BookingRequestDTO bookingRequestDTO, String pnr) {
        for (int i = 0; i < bookingRequestDTO.getBerthRequestDTOList().size(); i++) {
            TrainSeat trainSeat = trainSeats.get(i);
            BerthRequestDTO berthRequestDTO = bookingRequestDTO.getBerthRequestDTOList().get(i);
            updateSeatAvailabilityAfterAllocation(trainSeat);
            TrainSeatAvailability availability = trainSeat.getAssociatedtrainSeatAvailability();
            Booking booking = new Booking();
            booking.setTrainId(bookingRequestDTO.getTrainId());
            booking.setCoachTypeId(availability.getCoachTypeId());
            booking.setBoardingStationId(bookingRequestDTO.getSourceStationId());
            booking.setDestinationStationId(bookingRequestDTO.getDestinationStationId());
            booking.setJourneyDate(availability.getJourneyStartDate());
            booking.setPassengerName(berthRequestDTO.getPassengerName());
            booking.setSeatNumber(trainSeat.getSeatNumber());
            booking.setSeatIndex(trainSeat.getSeatIndex());
            booking.setPassengerClassId(berthRequestDTO.getGetPassengerConcessionClassId());
            booking.setStatus(BookingStatus.PAYMENT_IN_PROGRESS.name());
            booking.setSeatType(berthRequestDTO.getSeatPreference());
            bookingRepository.save(booking);
            trainSeatAvailabiltyRepository.save(availability);
            //trainSeatAvailabiltyRepository.updateAvailability(availability.getId(), availability.getSeatsAvailable(), availability.getWindowSeatsAvailable(), availability.getAisleSeatsAvailable(), availability.getWindowSeatsBookingMap(), availability.getAisleSeatsBookingMap());
        }


    }

    public void updateSeatAvailabilityAfterAllocation(TrainSeat allocatedTrainSeat) {
        //i do not need to check if count goes to 0 as i am already using a blocking queue
        if (allocatedTrainSeat.getSeatType() == SeatType.AISLE) {
            TrainSeatAvailability availability = allocatedTrainSeat.getAssociatedtrainSeatAvailability();
            String aisleSeatMap = availability.getAisleSeatsBookingMap();
            char[] aisleSeatCharArray = aisleSeatMap.toCharArray();
            aisleSeatCharArray[allocatedTrainSeat.getSeatIndex()] = 'B';
            String updatedAisleSeatMap = new String(aisleSeatCharArray);
            availability.setAisleSeatsBookingMap(updatedAisleSeatMap);
            availability.setSeatsAvailable(availability.getSeatsAvailable() - 1);
            availability.setAisleSeatsAvailable(availability.getAisleSeatsAvailable() - 1);
            return;
        }
        if (allocatedTrainSeat.getSeatType() == SeatType.WINDOW) {
            TrainSeatAvailability availability = allocatedTrainSeat.getAssociatedtrainSeatAvailability();
            String windowSeatsBookingMap = availability.getWindowSeatsBookingMap();
            char[] windowSeatsCharArray = windowSeatsBookingMap.toCharArray();
            windowSeatsCharArray[allocatedTrainSeat.getSeatIndex()] = 'B';
            String updatedWindowSeatMap = new String(windowSeatsCharArray);
            availability.setWindowSeatsBookingMap(updatedWindowSeatMap);
            availability.setSeatsAvailable(availability.getSeatsAvailable() - 1);
            availability.setWindowSeatsAvailable(availability.getWindowSeatsAvailable() - 1);
        }
    }

    @Override
    public CancellationResponseDTO cancel(CancellationRequestDTO cancellationRequest) throws CancellationException {
        return null;
    }

    @Override
    public BookingConfirmationResponse confirm(BookingConfirmationRequest bookingConfirmationRequest) throws BookingException {
        return null;
    }

    @PostConstruct
    private void postConstruct() {
        //call token service to get a list of all requests this booking service instance should handle
        bookingSetToHandleList = tokenService.registerMachine(machineName);
        seatAllocationService.constructAllocator(bookingSetToHandleList);
    }
}
