package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.StationListResponse;
import dev.abhinav.IRCTC.dto.TrainDTO;
import dev.abhinav.IRCTC.dto.TrainRouteDTO;
import dev.abhinav.IRCTC.dto.TrainsBetweenStationsResponse;
import dev.abhinav.IRCTC.entity.Train;
import dev.abhinav.IRCTC.exceptions.SearchParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements ISearchService {
    @Autowired
    IRouteInformationService routeInformationService;

    @Override
    public void validateSearchParameters(Long sourceStationId, Long destinationStationId, LocalDate date) throws SearchParametersException {

    }

    @Override
    public TrainsBetweenStationsResponse findTrainsBetweenStations(Long sourceStationId, Long destinationStationId, LocalDate date) {
//        LocalDate localDate=convertToLocalDateViaInstant(date);
        List<Train> trainList = routeInformationService.getTrains(sourceStationId, destinationStationId, date.getDayOfWeek());
        TrainsBetweenStationsResponse response = new TrainsBetweenStationsResponse();
        ArrayList<TrainDTO> trains = new ArrayList<>();
        if (trains != null) {
            for (Train train : trainList) {
                trains.add(new TrainDTO(train));
            }
        }
        response.setTrains(trains);
        return response;
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
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
