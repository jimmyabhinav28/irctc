package dev.abhinav.IRCTC.controller;

import dev.abhinav.IRCTC.dto.*;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import dev.abhinav.IRCTC.service.IBookingService;
import dev.abhinav.IRCTC.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class BookingController {
    @Autowired
    IBookingService IBookingService;

    @Autowired
    ITokenService tokenService;

    @GetMapping(path="/booking/initiateBooking")
    public BookingIntitationResponseDTO initiateBooking(@RequestParam(name="userId",required = true)String userId,@RequestParam(name="trainId",required = true)Long trainId,@RequestParam(name = "journeyDate", required = true) String journeyDate,@RequestParam(name = "coachTypeId", required = true) Long coachTypeId)
    {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate journeyStartLocalDate=LocalDate.parse(journeyDate,formatter);
        String token=tokenService.getBookingToken(userId,trainId,journeyStartLocalDate,coachTypeId);
        BookingIntitationResponseDTO bookingIntitationResponseDTO=new BookingIntitationResponseDTO();
        bookingIntitationResponseDTO.setBookingInitiationToken(token);
        return bookingIntitationResponseDTO;
    }
    @PutMapping(path = "/booking/book")
    public BookingResponseDTO bookTicket(@RequestHeader(name="X-forwarded-to") String bookingToken,@Valid @RequestBody BookingRequestDTO bookingRequestDTO) throws BookingException {
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
