package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class TrainStopDTO {
    String stationName;
    Long stationId;
    LocalTime arrivalTime;
    LocalTime departureTime;
    Integer distanceFromSourc;
    Integer daysSinceStart;
}
