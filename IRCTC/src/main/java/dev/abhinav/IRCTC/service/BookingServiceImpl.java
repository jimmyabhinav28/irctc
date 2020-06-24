package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import dev.abhinav.IRCTC.exceptions.SeatAllocationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {

    @Value("${machine.name}")
    String machineName;
    @Autowired
    ITokenService tokenService;
    private List<BookingSetToHandle> bookingSetToHandleList;

    @Autowired
    private ISeatAllocationService seatAllocationService;

    @Override
    public BookingResponseDTO book(BookingRequestDTO bookingRequestDTO) throws BookingException {
        BookingResponseDTO bookingResponseDTO= null;
        try {
            bookingResponseDTO = seatAllocationService.allocate(bookingRequestDTO);
        } catch (SeatAllocationException e) {
            log.error("error occured while allocating seats in booking request ",e);
            throw new BookingException("error occured while booking");
        }
        return bookingResponseDTO;
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
    private void postConstruct()
    {
        //call token service to get a list of all requests this booking service instance should handle
        bookingSetToHandleList=tokenService.registerMachine(machineName);
        seatAllocationService.constructAllocator(bookingSetToHandleList);
    }
}
