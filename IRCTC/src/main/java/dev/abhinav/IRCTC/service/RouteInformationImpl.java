package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dao.SourceDestinationPair;
import dev.abhinav.IRCTC.dao.TrainScheduleRepository;
import dev.abhinav.IRCTC.entity.Train;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class RouteInformationImpl implements IRouteInformationService {
    private final ConcurrentHashMap<String, List<Train>> reachabilityCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String,Integer> distanceMap=new ConcurrentHashMap<>();

    @Autowired
    TrainScheduleRepository trainScheduleRepository;

    @Override
    public void populateRouteAndDistanceCache() {
        List<SourceDestinationPair> sourceDestinationPairs = trainScheduleRepository.getAllPossibleSourceDestinationCombination();
        for (SourceDestinationPair pair : sourceDestinationPairs) {
            log.info("source destination pair " + pair.toString());
            String key = getKey(pair);
            if (reachabilityCache.containsKey(key))
                reachabilityCache.get(key).add(pair.getTrain());
            else
            {
                ArrayList<Train> trains=new ArrayList<>();
                trains.add(pair.getTrain());
                reachabilityCache.put(key,trains);
            }

            String distanceKey=getDistanceKey(pair.getSourceStationId(),pair.getDestinationStationId(),pair.getTrain().getId());
            distanceMap.put(distanceKey,pair.getDistance());
        }
    }

    private String getDistanceKey(Long sourceStationId,Long destinationStationId,Long trainId) {
        return String.valueOf(sourceStationId) + "_" + String.valueOf(destinationStationId)+"_"+String.valueOf(trainId);
    }
    private String getKey(SourceDestinationPair pair) {
        return pair.getSourceStationId() + "_" + pair.getDestinationStationId() + "_" + pair.getTrainStartDayOfWeek().getValue();
    }
    private String getKey(Long sourceStationId,Long destinationStationId,DayOfWeek dayOfWeek) {
        return sourceStationId+"_"+destinationStationId+"_"+dayOfWeek.getValue();
    }

    @Override
    public List<Train> getTrains(Long source, Long destination, DayOfWeek dayOfWeek) {
        String key=getKey(source,destination,dayOfWeek);
//        if(reachabilityCache.isEmpty())
//        {
//            populateRouteAndDistanceCache();
//        }
        if(reachabilityCache.containsKey(key))
            return reachabilityCache.get(key);
        return null;
    }

    @Override
    public Integer getDistanceBetweenTwoStation(Long sourceStationId, Long destinationStationId,Long trainId) {
        String distanceKey=getDistanceKey(sourceStationId,destinationStationId,trainId);
        return distanceMap.get(distanceKey);
    }

    @PostConstruct
    public void postConstruct()
    {
        populateRouteAndDistanceCache();
    }

}
