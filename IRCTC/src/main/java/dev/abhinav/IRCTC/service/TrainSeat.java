package dev.abhinav.IRCTC.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainSeat {
    Long trainId;
    Integer coachTypeId;
    String seatNumber;
    String coachIdentifier;
    SeatType seatType;
}
