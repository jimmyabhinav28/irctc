package dev.abhinav.IRCTC.dto;

import dev.abhinav.IRCTC.entity.Train;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TrainDTO {

    Long id;
    Long trainNumber;
    String name;

    public TrainDTO(Train train) {
        this.id = train.getId();
        this.trainNumber = train.getTrainNumber();
        this.name = train.getName();
    }
}
