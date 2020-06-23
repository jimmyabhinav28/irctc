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
@Table(name = "seat_availability")
public class TrainAvailability extends AuditableEntity {
    //another weak table here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "train_id")
    Long trainId;
    @Column(name = "coach_type_id")
    Integer coachTypeId;

    @Column(name = "journey_start_date")
    @Temporal(TemporalType.DATE)
    Date journeyStartDate;

    @Column(name = "seats_available")
    Integer seatsAvailable;
}
