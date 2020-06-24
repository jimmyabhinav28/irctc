package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dao.CoachTypeRepository;
import dev.abhinav.IRCTC.dao.PassengerTypeRepository;
import dev.abhinav.IRCTC.entity.CoachType;
import dev.abhinav.IRCTC.entity.PassengerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class FareServiceImpl implements IFareService {
@Autowired
IRouteInformationService routeInformationService;
@Autowired
PassengerTypeRepository passengerTypeRepository;
@Autowired
CoachTypeRepository coachTypeRepository;

private HashMap<Integer, PassengerType> passengerTypeCache=new HashMap<>();
private HashMap<Integer, CoachType> coachTypeCache=new HashMap<>();
    @Override
    public Float calculateFare(Integer coachTypeId, Long sourceStationId, Long destinationStationId, Long trainId, Integer passengerTypeId) {
    Integer distance=routeInformationService.getDistanceBetweenTwoStation(sourceStationId,destinationStationId,trainId);
    CoachType coachType=coachTypeCache.get(coachTypeId);
    Float basefarePerKm=coachType.getFarePerKm();
    PassengerType passengerType=passengerTypeCache.get(passengerTypeId);
    Float discountPercentage=passengerType.getDiscountPercentage();

    Float baseFare=distance*basefarePerKm;
    Float chargePercentage=100f-discountPercentage;
    Float discountedCharge=chargePercentage*baseFare/100;
    return discountedCharge;
    }

    public void populateCache()
    {
        List<CoachType> coachTypeList=coachTypeRepository.findAll();
        for(CoachType coachType:coachTypeList)
        {
            coachTypeCache.put(coachType.getId(),coachType);
        }
        List<PassengerType> passengerTypeList=passengerTypeRepository.findAll();
        for(PassengerType passengerType: passengerTypeList)
        {
            passengerTypeCache.put(passengerType.getId(),passengerType);
        }
    }
    @PostConstruct
    public void postConstruct()
    {
        populateCache();
    }
}
