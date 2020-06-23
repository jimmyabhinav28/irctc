package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Valid
@Getter
@Setter
public class BerthRequestDTO {

    @NotEmpty(message = "passenger name cannot be empty")
    String passengerName;
    @NotEmpty(message = "passenger name cannot be empty")
    String passengerConcessionClass;
    @NotEmpty(message = "passenger name cannot be empty")
    String seatPreference;
}
