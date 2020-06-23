package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements IBookingService {
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
}
