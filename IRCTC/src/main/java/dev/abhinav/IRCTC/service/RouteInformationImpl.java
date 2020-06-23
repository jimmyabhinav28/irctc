package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dao.SourceDestinationPair;
import dev.abhinav.IRCTC.dao.TrainScheduleRepository;
import dev.abhinav.IRCTC.entity.Train;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class RouteInformationImpl implements IRouteInformationService {
    private final ConcurrentHashMap<String, List<Train>> reachabilityCache = new ConcurrentHashMap<>();

    @Autowired
    TrainScheduleRepository trainScheduleRepository;

    @Override
    public void populateRouteCache() {
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

        }
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
        if(reachabilityCache.isEmpty())
        {
            populateRouteCache();
        }
        if(reachabilityCache.containsKey(key))
            return reachabilityCache.get(key);
        return null;
    }
}
