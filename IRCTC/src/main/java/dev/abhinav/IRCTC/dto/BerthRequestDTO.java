package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Valid
@Getter
@Setter
public class BerthRequestDTO {

    @NotEmpty(message = "passenger name cannot be empty")
    String passengerName;
    @NotNull(message = "passenger concession class cannot be empty")
    Integer getPassengerConcessionClassId;
    @NotEmpty(message = "seat preference name cannot be empty")
    @Pattern(regexp = "window|aisle", message = "seat preference can only be window or aisle")
    String seatPreference;
}
