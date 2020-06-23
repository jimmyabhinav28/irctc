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

    @Column(name = "is_source")
    Boolean isSource;
    /*
coach_class varchar(20),
total_seats int not null,
window_seats int not null,
aisle_seats int not null,
fare_per_km float(5,2) not null,created_at timestamp,
     */
}
