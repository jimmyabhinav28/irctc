package dev.abhinav.IRCTC.service;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BookingSetToHandle {
    Long trainId;
    Integer coachTypeId;
    LocalDate journeyDate;
}
