package dev.abhinav.IRCTC.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "train_coach")
public class TrainCoachRecord extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_id")
    Train train;

    @ManyToOne
    @JoinColumn(name = "coach_type_id")
    CoachType coachType;
    @Column(name = "coach_identifier")
    String coachIdentifier;
}
