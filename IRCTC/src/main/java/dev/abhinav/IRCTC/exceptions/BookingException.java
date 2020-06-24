package dev.abhinav.IRCTC.exceptions;

import dev.abhinav.IRCTC.dto.BookingResponseDTO;

public class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}
