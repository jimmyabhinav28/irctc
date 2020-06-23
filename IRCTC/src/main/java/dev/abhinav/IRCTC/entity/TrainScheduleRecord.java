package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@Getter
@Setter
@ToString
@Entity
@Table(name = "train_schedule")
public class TrainScheduleRecord extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    Train train;

    @ManyToOne
    @JoinColumn(name = "station_id")
    Station station;

    @Column(name = "stop_number")
    Integer stopNumber;

    @Column(name = "arrival_day_of_week")
    @Enumerated(EnumType.ORDINAL)
    DayOfWeek dayOfWeek;

    @Column(name = "arrival_day_from_source")
    Integer arrivalDayFromSource;

    @Column(name = "arrival_day_from_source")
    @Temporal(TemporalType.TIME)
    Time ArrivalTime;

    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    Time departureTime;

    @Column(name = "distance_from_source")
    Integer distanceFromSource;

}
