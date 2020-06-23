package dev.abhinav.IRCTC.controller;

import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import dev.abhinav.IRCTC.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookingController {
    @Autowired
    IBookingService IBookingService;

    @PutMapping(path = "/booking/book")
    public BookingResponseDTO bookTicket(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) throws BookingException {
        BookingResponseDTO responseDTO = IBookingService.book(bookingRequestDTO);
        return responseDTO;
    }

    @PutMapping(path = "/booking/confirm")
    public BookingConfirmationResponse confirmBooking(@Valid @RequestBody BookingConfirmationRequest bookingConfirmationRequest) throws BookingException {
        BookingConfirmationResponse responseDTO = IBookingService.confirm(bookingConfirmationRequest);
        return responseDTO;
    }

    @PutMapping(path = "/booking/cancel")
    public CancellationResponseDTO bookTicket(@Valid @RequestBody CancellationRequestDTO cancellationRequest) throws CancellationException {
        CancellationResponseDTO responseDTO = IBookingService.cancel(cancellationRequest);
        return responseDTO;
    }
}
