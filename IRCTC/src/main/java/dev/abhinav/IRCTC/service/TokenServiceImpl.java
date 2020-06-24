package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.Constants;
import dev.abhinav.IRCTC.dao.TrainSeatAvailabiltyRepository;
import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenServiceImpl implements ITokenService {

    @Value("${advance.booking.window.days}")
    Integer advanceBookingWindowDays;

    private Integer getAdvanceBookingWindowDays()
    {
        if(advanceBookingWindowDays!=null)
            return advanceBookingWindowDays;

        return Constants.DEFAULT_ADVANCE_BOOKING_WINDOW;
    }
    private HashMap<String, BookingSetToHandle> prefetchedBookingSetToHandle = new HashMap<>();
    private HashMap<String,String> bookingSetKeyToMachineMap=new HashMap<>();

    @Autowired
    TrainSeatAvailabiltyRepository trainSeatAvailabiltyRepository;

    private ConcurrentHashMap<String, String> tokenToMachineMap = new ConcurrentHashMap<>();
    private HashSet<String> registeredMachines = new HashSet<String>();

    @Override
    public String getBookingToken(String userId, Long trainId, LocalDate journeyStartDate, Integer coachTypeId) {
        Date date=getDateFromLocalDate(journeyStartDate);
        return getKey(trainId,coachTypeId,date);
    }

    private String getKey(TrainSeatAvailability availability)
    {
        return String.valueOf(availability.getTrainId())+"_"+String.valueOf(availability.getCoachTypeId())+"_"+availability.getJourneyStartDate().toString();
    }

    private String getKey(Long trainId,Integer coachTypeId,Date journeyStartDate)
    {
        return String.valueOf(trainId)+"_"+String.valueOf(coachTypeId)+"_"+journeyStartDate.toString();
    }

    @Override
    public String getServiceMachineFromToken(String token) {
        return bookingSetKeyToMachineMap.get(token);
    }

    //this implementation is just a dummy implementation.
    //As of now all bookings are handled by a single system
    @Override
    public List<BookingSetToHandle> registerMachine(String machineName) {

        List<BookingSetToHandle> bookingSetToHandleList=new ArrayList<>();
        for(String s:prefetchedBookingSetToHandle.keySet())
        {
            bookingSetToHandleList.add(prefetchedBookingSetToHandle.get(s));
            bookingSetKeyToMachineMap.put(s,machineName);
        }
        return bookingSetToHandleList;
    }

    public void refreshBookingSetToHandle() {
        LocalDate advanceWindowCloseDate = getDaysAfter(LocalDate.now(), getAdvanceBookingWindowDays());
        Date endDate=getDateFromLocalDate(advanceWindowCloseDate);
        List<TrainSeatAvailability> trainSeatAvailabilities=trainSeatAvailabiltyRepository.findAllByJourneyStartDateGreaterThanAndJourneyStartDateLessThanEqual(LocalDate.now(),advanceWindowCloseDate);
        for(TrainSeatAvailability availability: trainSeatAvailabilities)
        {
            String key=getKey(availability);
            BookingSetToHandle bookingSetToHandle=new BookingSetToHandle();
            bookingSetToHandle.setTrainId(availability.getTrainId());
            bookingSetToHandle.setCoachTypeId(availability.getCoachTypeId());
            bookingSetToHandle.setJourneyDate(availability.getJourneyStartDate());
            prefetchedBookingSetToHandle.put(key,bookingSetToHandle);
        }
    }
    @PostConstruct
    public void postConstruct() {
       refreshBookingSetToHandle();
    }


    private Date getDateFromLocalDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }
    private LocalDate getDaysAfter(LocalDate date, int daysAfter) {
        return date.plusDays(daysAfter);
    }

}
