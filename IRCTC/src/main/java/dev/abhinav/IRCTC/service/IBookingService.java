package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;

public interface IBookingService {
    BookingResponseDTO book(BookingRequestDTO bookingRequestDTO) throws BookingException;

    CancellationResponseDTO cancel(CancellationRequestDTO cancellationRequest) throws CancellationException;

    BookingConfirmationResponse confirm(BookingConfirmationRequest bookingConfirmationRequest) throws BookingException;
}
