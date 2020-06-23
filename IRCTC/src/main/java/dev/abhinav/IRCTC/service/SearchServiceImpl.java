package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.StationListResponse;
import dev.abhinav.IRCTC.dto.TrainRouteDTO;
import dev.abhinav.IRCTC.dto.TrainsBetweenStationsResponse;
import dev.abhinav.IRCTC.exceptions.SearchParametersException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SearchServiceImpl implements ISearchService {
    @Override
    public void validateSearchParameters(Long sourceStationId, Long destinationStationId, Date date) throws SearchParametersException {

    }

    @Override
    public TrainsBetweenStationsResponse findTrainsBetweenStations(Long sourceStationId, Long destinationStationId, Date date) {
        return null;
    }

    @Override
    public void validateTrainId(Long trainId) throws SearchParametersException {

    }

    @Override
    public TrainRouteDTO getTrainRoute(Long trainId) {
        return null;
    }

    @Override
    public StationListResponse getStationList() {
        return null;
    }
}
