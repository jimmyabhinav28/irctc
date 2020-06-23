package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.entity.Train;

import java.time.DayOfWeek;
import java.util.List;

public interface IRouteInformationService {

    void populateRouteCache();

    /**
     *
     * @param sourceStationId
     * @param destinationStationId
     * @param dayOfWeek
     * @return list of trains if there are trains, else null
     */
    public List<Train> getTrains(Long sourceStationId, Long destinationStationId, DayOfWeek dayOfWeek);

}


