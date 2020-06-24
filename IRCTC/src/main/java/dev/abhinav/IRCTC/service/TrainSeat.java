package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainSeat {
    Long trainId;
    Integer coachTypeId;
    String seatNumber;
    String coachIdentifier;
    Integer seatIndex;
    SeatType seatType;
    TrainSeatAvailability associatedtrainSeatAvailability;
}
