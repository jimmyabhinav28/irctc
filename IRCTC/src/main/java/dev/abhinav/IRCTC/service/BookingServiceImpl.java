package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {

    @Value("${machine.name}")
    String machineName;
    @Autowired
    ITokenService tokenService;
    private List<BookingSetToHandle> bookingSetToHandle;

    @Autowired
    private ISeatAllocationService seatAllocationService;

    @Override
    public BookingResponseDTO book(BookingRequestDTO bookingRequestDTO) throws BookingException {
        return null;
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
        bookingSetToHandle=tokenService.registerMachine(machineName);
    }
}
