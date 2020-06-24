package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerBerth {
    String coachIdentifier;
    String berthNumber;
    String berthPreference;
}
