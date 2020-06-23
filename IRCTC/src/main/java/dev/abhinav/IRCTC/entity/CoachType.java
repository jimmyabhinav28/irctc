package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "coach_type")
public class CoachType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "coach_class")
    String coachClass;

    @Column(name = "total_seats")
    Integer totalSeats;

    @Column(name = "aisle_seats")
    Integer aisleSeats;

    @Column(name = "window_seats")
    Integer windowSeats;

    @Column(name = "fare_per_km")
    Float farePerKm;


    /*
coach_class varchar(20),
total_seats int not null,
window_seats int not null,
aisle_seats int not null,
fare_per_km float(5,2) not null,created_at timestamp,
     */
}
