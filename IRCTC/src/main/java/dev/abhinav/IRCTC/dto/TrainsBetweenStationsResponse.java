package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TrainsBetweenStationsResponse {
    List<TrainDTO> trains;
}
