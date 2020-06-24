package dev.abhinav.IRCTC.service;

public interface IFareService {
    Float calculateFare(Integer coachTypeId, Long sourceStationId, Long destinationStationId, Long trainId, Integer passengerTypeId);
}
