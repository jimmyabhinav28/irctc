package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "train_id")
    Long trainId;

    @Column(name = "passenger_name")
    String passengerName;

    @Column(name = "coach_type_id")
    Integer coachTypeId;

    @Column(name = "seat_number")
    String seatNumber;

    @Column(name = "seat_index")
    Integer seatIndex;

    @Column(name = "seat_type")
    String seatType;

    @Column(name = "passenger_class_id")
    Integer passengerClassId;

    @Column(name = "journey_date")
    LocalDate journeyDate;

    @Column(name = "pnr")
    String pnr;

    @Column(name = "boarding_station_id")
    Long boardingStationId;

    @Column(name = "destination_station_id")
    Long destinationStationId;

    @Column(name = "status")
    String status;

}
