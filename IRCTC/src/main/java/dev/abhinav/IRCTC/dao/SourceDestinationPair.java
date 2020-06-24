package dev.abhinav.IRCTC.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.abhinav.IRCTC.entity.Train;
import dev.abhinav.IRCTC.entity.TrainScheduleRecord;
import lombok.*;

import java.time.DayOfWeek;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
public class SourceDestinationPair {
    Train train;
    DayOfWeek trainStartDayOfWeek;
    Long sourceStationId;
    Long destinationStationId;
    Integer distance;
    Integer sourceStopNumber;
    Integer destinationStopNumber;
    public SourceDestinationPair(TrainScheduleRecord source, TrainScheduleRecord destination) {
        this.train = source.getTrain();
        this.trainStartDayOfWeek = source.getDayOfWeek();
        sourceStationId = source.getStation().getId();
        destinationStationId = destination.getStation().getId();
        distance = destination.getDistanceFromSource() - source.getDistanceFromSource();
        sourceStopNumber = source.getStopNumber();
        destinationStopNumber = destination.getStopNumber();
    }

}
