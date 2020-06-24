package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingResponseDTO {
    String pnr;
    Float fare;
    List<PassengerBerth> allocatedPassengerBerth;
}
