package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.StationListResponse;
import dev.abhinav.IRCTC.dto.TrainRouteDTO;
import dev.abhinav.IRCTC.dto.TrainsBetweenStationsResponse;
import dev.abhinav.IRCTC.exceptions.SearchParametersException;

import java.util.Date;

public interface ISearchService {
    void validateSearchParameters(Long sourceStationId, Long destinationStationId, Date date) throws SearchParametersException;

    TrainsBetweenStationsResponse findTrainsBetweenStations(Long sourceStationId, Long destinationStationId, Date date);

    void validateTrainId(Long trainId) throws SearchParametersException;

    TrainRouteDTO getTrainRoute(Long trainId);

    StationListResponse getStationList();
}
