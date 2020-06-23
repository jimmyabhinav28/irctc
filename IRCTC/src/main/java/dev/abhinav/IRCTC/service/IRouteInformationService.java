package dev.abhinav.IRCTC.service;

import java.time.DayOfWeek;

public interface IRouteInformationService {

    public void populateRouteCache();
    public boolean checkIfRouteExists(Long source, Long destination, DayOfWeek dayOfWeek);
    public 
}
