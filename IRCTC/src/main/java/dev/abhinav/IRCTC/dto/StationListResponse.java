package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StationListResponse {

    List<StationDTO> stationDTOList;
}
