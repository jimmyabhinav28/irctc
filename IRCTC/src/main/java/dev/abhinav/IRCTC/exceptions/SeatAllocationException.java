package dev.abhinav.IRCTC.exceptions;

import javax.validation.constraints.NotEmpty;

public class SeatAllocationException extends Throwable {
    public SeatAllocationException(@NotEmpty(message = "passenger name cannot be empty") String s) {
    }
}
