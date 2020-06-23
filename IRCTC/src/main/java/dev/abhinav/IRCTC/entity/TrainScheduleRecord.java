package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;

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

    @Column(name = "source_start_day_of_week")
    @Enumerated(EnumType.ORDINAL)
    DayOfWeek sourceStartDayOfWeek;

    @Column(name = "arrival_day_of_week")
    @Enumerated(EnumType.ORDINAL)
    DayOfWeek dayOfWeek;

    @Column(name = "arrival_day_from_source")
    Integer arrivalDayFromSource;

    @Column(name = "arrivalTime")
    String arrivalTime;

    @Column(name = "departure_time")
    String departureTime;

    @Column(name = "distance_from_source")
    Integer distanceFromSource;

}
