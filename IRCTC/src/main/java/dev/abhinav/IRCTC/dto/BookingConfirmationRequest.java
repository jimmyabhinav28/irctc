package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class BookingConfirmationRequest {
    @NotEmpty(message = "pnr cannot be empty")
    String pnr;
}
