package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BookingRequestDTO {

    @NotNull(message = "train id cannot be null")
    Long trainId;

    @NotNull(message = "source station id cannot be null")
    Long sourceStationId;

    @NotNull(message = "destination station id cannot be null")
    Long destinationStationId;

    @NotNull(message = "journey date cannot be null")
    Date journeyDate;

    @NotEmpty(message = "coach class cannot be null or empty")
    Integer coachTypeId;

    @Size(min = 1, max = 5)
    List<BerthRequestDTO> berthRequestDTOList;
}
