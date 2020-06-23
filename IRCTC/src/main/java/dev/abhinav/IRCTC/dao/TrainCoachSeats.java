package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.CoachType;
import dev.abhinav.IRCTC.entity.Train;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainCoachSeats {
    Long trainId;
    String coachIdentifier;
    String trainName;
    Integer coachTypeId;
    String coachClass;
    Integer totalNumberOfSeats;
    Integer numberOfWindowSeats;
    Integer numberOfAisleSeats;

    public TrainCoachSeats(Long trainId, String trainName, Integer coachTypeId, String coachIdentifier,String coachClass, Integer totalNumberOfSeats, Integer numberOfWindowSeats, Integer numberOfAisleSeats) {
        this.trainId=trainId;
        this.trainName = trainName;
        this.coachTypeId = coachTypeId;
        this.coachIdentifier=coachIdentifier;
        this.coachClass = coachClass;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.numberOfWindowSeats = numberOfWindowSeats;
        this.numberOfAisleSeats = numberOfAisleSeats;
    }
}
