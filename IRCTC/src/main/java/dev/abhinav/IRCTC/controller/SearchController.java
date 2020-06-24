package dev.abhinav.IRCTC.controller;

import dev.abhinav.IRCTC.dto.StationListResponse;
import dev.abhinav.IRCTC.dto.TrainRouteDTO;
import dev.abhinav.IRCTC.dto.TrainsBetweenStationsResponse;
import dev.abhinav.IRCTC.exceptions.SearchParametersException;
import dev.abhinav.IRCTC.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@RestController
public class SearchController {

    @Autowired
    ISearchService ISearchService;

    @GetMapping(path = "/search/trainsBetweenStations")
    public TrainsBetweenStationsResponse getTrainsBetweenStations(@RequestParam(name = "sourceStationId", required = true) Long sourceStationId, @RequestParam(name = "destinationStationId", required = true) Long destinationStationId, @RequestParam(name = "journeyDate", required = true) String journeyDate) throws SearchParametersException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate localDate = LocalDate.parse(journeyDate, formatter);
        ISearchService.validateSearchParameters(sourceStationId, destinationStationId, localDate);

        return ISearchService.findTrainsBetweenStations(sourceStationId, destinationStationId, localDate);
    }

    @GetMapping(path = "/search/trainRoute")
    public TrainRouteDTO getTrainRoute(@RequestParam(name = "trainId", required = true) Long trainId) throws SearchParametersException {
        ISearchService.validateTrainId(trainId);
        return ISearchService.getTrainRoute(trainId);
    }

    @GetMapping(path = "/search/stationList")
    public StationListResponse getStationList() {
        return ISearchService.getStationList();
    }
}
