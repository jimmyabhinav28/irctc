package dev.abhinav.IRCTC.exceptions;

import javax.validation.constraints.NotEmpty;

public class SeatAllocationException extends Throwable {
    public SeatAllocationException(String message) {
        super(message);
    }
}
