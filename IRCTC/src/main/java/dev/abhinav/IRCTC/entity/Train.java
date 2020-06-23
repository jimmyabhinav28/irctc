package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
//@ToString
@Entity
@Table(name = "train_details")
public class Train extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "train_number")
    Long trainNumber;

    @Column(name = "name")
    String name;

    @Column(name = "is_active")
    Boolean isActive;

    @OneToMany(mappedBy = "train")
    Set<TrainScheduleRecord> trainScheduleRecords;

    @OneToMany(mappedBy = "train")
    Set<TrainCoachRecord> trainCoachRecords;

}
