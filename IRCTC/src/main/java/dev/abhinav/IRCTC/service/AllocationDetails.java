package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.PassengerBerth;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllocationDetails {
    List<TrainSeat> trainSeatsList;
    List<PassengerBerth> passengerBerthList;
    String pnr;
    Float totalFare;
}
