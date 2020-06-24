package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.entity.TrainSeatAvailability;

import java.util.Date;
import java.util.List;

public interface IAvailabilityService {
    public void fillInitialAvailibility();

    public List<TrainSeatAvailability> getTrainSeatAvailability(String trainId, Date trainSourceStartDate);
}
