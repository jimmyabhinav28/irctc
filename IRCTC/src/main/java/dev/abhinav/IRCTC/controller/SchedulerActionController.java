package dev.abhinav.IRCTC.controller;

import dev.abhinav.IRCTC.service.IAvailabilityService;
import dev.abhinav.IRCTC.service.IRouteInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
this controller will be refactored out into another application which handles scheduled activities
 */
@RestController

public class SchedulerActionController {

    @Autowired
    IRouteInformationService routeInformationService;

    @Autowired
    IAvailabilityService availabilityService;

    //this endpoint is meant to be hit every night at 11:30 p.m to build an in memory cache of route information.
    //the in memory cache is basically a concurrent hashMap. this cache can be re-populated again
    //on server restart
    //or in case if the server does not need to restart, this will be refreshed on a scheduled basis
    @GetMapping("/ops/prefetchSourceDestinationPairs")
    public void cachePointToPointReachabilityInfo() {
        routeInformationService.populateRouteAndDistanceCache();
    }

    //this end point is also meant to be hit on a scheduled basis at 11:30 p.m
    //this will ready the database for the new trains that open for booking the next day
    @GetMapping("/ops/fillInitialAvailability")
    public void fillInitialAvailability() {
        availabilityService.fillInitialAvailibility();
    }
}
