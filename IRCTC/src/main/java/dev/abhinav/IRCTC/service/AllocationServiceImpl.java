package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.Constants;
import dev.abhinav.IRCTC.dao.BookingRepository;
import dev.abhinav.IRCTC.dao.TrainSeatAvailabiltyRepository;
import dev.abhinav.IRCTC.dto.BerthRequestDTO;
import dev.abhinav.IRCTC.dto.BookingRequestDTO;
import dev.abhinav.IRCTC.dto.BookingResponseDTO;
import dev.abhinav.IRCTC.dto.PassengerBerth;
import dev.abhinav.IRCTC.entity.Booking;
import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import dev.abhinav.IRCTC.exceptions.SeatAllocationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

@Service
@Slf4j
public class AllocationServiceImpl implements ISeatAllocationService {

    @Autowired
    private TrainSeatAvailabiltyRepository trainSeatAvailabiltyRepository;


    @Autowired
    private IFareService fareService;
    private HashMap<String, ArrayBlockingQueue<TrainSeat>> seatSupply = new HashMap<>();


    @Override
    public void constructAllocator(List<BookingSetToHandle> bookingSetToHandle) {
        //create data structures to handle requests for each type booking set
        for (BookingSetToHandle bookingSet : bookingSetToHandle) {
            List<TrainSeatAvailability> trainSeatAvailabilities = trainSeatAvailabiltyRepository.getAllByTrainIdAndJourneyStartDateAndCoachTypeId(bookingSet.getTrainId(), bookingSet.getJourneyDate(), bookingSet.getCoachTypeId());
            for (TrainSeatAvailability availability : trainSeatAvailabilities) {
                createSeatFromAvailability(availability, SeatType.WINDOW);
                createSeatFromAvailability(availability, SeatType.AISLE);
            }
        }

    }

    private void createSeatFromAvailability(TrainSeatAvailability availability, SeatType seatType) {
        String prefix = "";
        if (seatType == SeatType.AISLE)
            prefix = Constants.AISLE_SEAT_BERTH_PREFIX;
        if (seatType == SeatType.WINDOW)
            prefix = Constants.WINDOW_SEAT_BERTH_PREFIX;

        ArrayBlockingQueue<TrainSeat> arrayBlockingQueue = new ArrayBlockingQueue<TrainSeat>(availability.getWindowSeatsAvailable());
        for (int i = 0; i < availability.getWindowSeatsAvailable(); i++) {
            //create new train seat
            TrainSeat trainSeat = new TrainSeat();
            trainSeat.setTrainId(availability.getTrainId());
            trainSeat.setSeatType(seatType);
            trainSeat.setCoachIdentifier(availability.getCoachIdentifier());
            trainSeat.setCoachTypeId(availability.getCoachTypeId());
            trainSeat.setSeatNumber(prefix + String.valueOf(i + 1));
            trainSeat.setSeatIndex(i);
            trainSeat.setAssociatedtrainSeatAvailability(availability);
            arrayBlockingQueue.add(trainSeat);
        }
        seatSupply.put(getKey(availability, seatType), arrayBlockingQueue);
    }

    private String getKey(TrainSeatAvailability availability, SeatType seatType) {
        return availability.getTrainId() + "_" + availability.getJourneyStartDate().toString() + "_" + availability.getCoachTypeId() + "_" + seatType.name().toLowerCase();
    }

    private String getKey(BookingRequestDTO bookingRequestDTO, BerthRequestDTO berthRequestDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate localDate = LocalDate.parse(bookingRequestDTO.getJourneyDate(), formatter);
        Date date = getDateFromLocalDate(localDate);
//        return bookingRequestDTO.getTrainId()+"_"+date.toString()+"_"+bookingRequestDTO.getCoachTypeId()+"_"+berthRequestDTO.getSeatPreference().toLowerCase();
        return bookingRequestDTO.getTrainId() + "_" + localDate.toString() + "_" + bookingRequestDTO.getCoachTypeId() + "_" + berthRequestDTO.getSeatPreference().toLowerCase();
    }

    @Override
    public AllocationDetails allocate(BookingRequestDTO bookingRequestDTO) throws SeatAllocationException {
        AllocationDetails allocationDetails = new AllocationDetails();
        BookingResponseDTO responseDTO = new BookingResponseDTO();
        List<PassengerBerth> passengerBerths = new ArrayList<>();
        List<TrainSeatAvailability> availabilitiesToUpdate = new ArrayList<>();
        List<TrainSeat> involvedTrainSeats = new ArrayList<>();
        float fare = 0;
        for (BerthRequestDTO berthRequest : bookingRequestDTO.getBerthRequestDTOList()) {
            String key = getKey(bookingRequestDTO, berthRequest);
            ArrayBlockingQueue<TrainSeat> blockingQueue = seatSupply.get(key);
            TrainSeat allocatedTrainSeat = null;
            if (blockingQueue != null)
                allocatedTrainSeat = blockingQueue.poll();
            if (allocatedTrainSeat == null) {
                String message = " could not fulfill request for " + berthRequest.getPassengerName() + " with berth preference " + berthRequest.getSeatPreference();
                throw new SeatAllocationException(message);
            }
            PassengerBerth passengerBerth = new PassengerBerth();
            passengerBerth.setCoachIdentifier(allocatedTrainSeat.getCoachIdentifier());
            passengerBerth.setBerthNumber(allocatedTrainSeat.getSeatNumber());
            passengerBerth.setBerthPreference(berthRequest.getSeatPreference());
            passengerBerths.add(passengerBerth);

            involvedTrainSeats.add(allocatedTrainSeat);

            fare += fareService.calculateFare(bookingRequestDTO.getCoachTypeId(), bookingRequestDTO.getSourceStationId(), bookingRequestDTO.getDestinationStationId(), bookingRequestDTO.getTrainId(), berthRequest.getGetPassengerConcessionClassId());
        }
        String pnr = generatePNR();
        allocationDetails.setPassengerBerthList(passengerBerths);
        allocationDetails.setTrainSeatsList(involvedTrainSeats);
        allocationDetails.setPnr(pnr);
        allocationDetails.setTotalFare(fare);
        return allocationDetails;

    }


    private Date getDateFromLocalDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    private String generatePNR() {
        return UUID.randomUUID().toString();
    }
}
