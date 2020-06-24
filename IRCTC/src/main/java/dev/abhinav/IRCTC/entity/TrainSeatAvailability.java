package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "train_seat_availability")
public class TrainSeatAvailability extends AuditableEntity {
    //another weak table here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "train_id")
    Long trainId;
    @Column(name = "coach_type_id")
    Integer coachTypeId;

    @Column(name = "journey_start_date")
    Date journeyStartDate;

    @Column(name = "seats_available")
    Integer seatsAvailable;

    @Column(name = "window_seats_available")
    Integer windowSeatsAvailable;

    @Column(name = "windows_seat_map")
    String windowSeatsBookingMap;

    @Column(name = "aisle_seats_available")
    Integer aisleSeatsAvailable;

    @Column(name = "aisle_seat_map")
    String aisleSeatsBookingMap;

    @Column(name = "coach_identifier")
    String coachIdentifier;
}
