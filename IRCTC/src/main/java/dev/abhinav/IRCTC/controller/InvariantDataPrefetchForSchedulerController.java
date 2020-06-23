package dev.abhinav.IRCTC.controller;

import dev.abhinav.IRCTC.service.IRouteInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InvariantDataPrefetchForSchedulerController {

    @Autowired
    IRouteInformationService routeInformationService;

    @GetMapping("/ops/prefetch")
    public void cachePointToPointReachabilityInfo()
    {
        routeInformationService.populateRouteCache();
    }
}
