package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.Constants;
import dev.abhinav.IRCTC.dao.*;
import dev.abhinav.IRCTC.entity.Train;
import dev.abhinav.IRCTC.entity.TrainAvailability;
import dev.abhinav.IRCTC.entity.TrainCoachRecord;
import dev.abhinav.IRCTC.entity.TrainScheduleRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.util.Date.from;

@Service
@Slf4j
public class AvailabilityServiceImpl implements IAvailabilityService {

@Value("${advance.booking.window.days}")
Integer advanceBookingWindowDays;


    private Integer getAdvanceBookingWindowDays()
    {
        if(advanceBookingWindowDays!=null)
           return advanceBookingWindowDays;

            return Constants.DEFAULT_ADVANCE_BOOKING_WINDOW;
    }
    @Autowired
    TrainAvailabiltyRepository trainAvailabiltyRepository;

    @Autowired
    TrainCoachRepository trainCoachRepository;
    @Autowired
    TrainScheduleRepository trainScheduleRepository;

    @Autowired
    TrainRepository trainRepository;

    @Override
    public void fillInitialAvailibility() {
        //find the dates for which you have to calculate initial availability
        //get dates till which we have availabilities in the table


        //for all dates between max+1 and booking window end
        //get day for each date
        //get all trains for each day
        //for each train create an initial availability
        Date lastAvailbilityDate = trainAvailabiltyRepository.getMaxAvailabilityDate();
        if(lastAvailbilityDate==null)
            lastAvailbilityDate=new Date();
        LocalDate lastAvailbilityLocalDate = convertToLocalDateViaInstant(lastAvailbilityDate);
        LocalDate advanceWindowCloseDate = getDaysAfter(LocalDate.now(), getAdvanceBookingWindowDays());
        int interveningDays = getDaysIntervening(lastAvailbilityLocalDate,advanceWindowCloseDate);

        for (int i = 1; i < interveningDays; i++) {
            LocalDate initialAvailabilityDate = getDaysAfter(lastAvailbilityLocalDate, i);
            DayOfWeek dayOfWeek = initialAvailabilityDate.getDayOfWeek();
            List<TrainScheduleRecord> trainsStartingOnThisWeekday = trainScheduleRepository.getAllBySourceStartDayOfWeek(dayOfWeek);
            if (trainsStartingOnThisWeekday != null) {
                for (TrainScheduleRecord record : trainsStartingOnThisWeekday) {
                    List<TrainCoachRecord> trainCoachRecords=trainCoachRepository.getAllByTrain(record.getTrain());
                    //List<TrainCoachSeats> trainCoachSeats = trainRepository.getTrainCoachSeatDetails(record.getTrain().getId());
                    /*if (trainCoachSeats != null) {
                        for (TrainCoachSeats tcs : trainCoachSeats) {
                            TrainAvailability trainAvailability = convertTrainCoachSeatToTrainAvailability(tcs, initialAvailabilityDate);
                            trainAvailabiltyRepository.save(trainAvailability);
                        }
                    }*/
                    if(trainCoachRecords!=null)
                    {
                        for(TrainCoachRecord trainCoachRecord: trainCoachRecords)
                        {
                            TrainAvailability trainAvailability = convertTrainCoachRecordToTrainAvailability(trainCoachRecord);
                            trainAvailabiltyRepository.save(trainAvailability);
                        }
                    }
                }
            }
        }
    }

    
   /* private TrainAvailability convertTrainCoachSeatToTrainAvailability(TrainCoachSeats tcs, LocalDate initialAvailabilityDate) {
        TrainAvailability trainAvailability = new TrainAvailability();
        trainAvailability.setCoachTypeId(tcs.getCoachTypeId());
        trainAvailability.setJourneyStartDate(getDateFromLocalDate(initialAvailabilityDate));
        trainAvailability.setSeatsAvailable(Integer.valueOf(tcs.getTotalNumberOfSeats().toString()));
        trainAvailability.setAisleSeatsAvailable(Integer.valueOf(tcs.getNumberOfAisleSeats().toString()));
        trainAvailability.setWindowSeatsAvailable(Integer.valueOf(tcs.getNumberOfWindowSeats().toString()));
        return trainAvailability;
    }*/

    private Date getDateFromLocalDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    private int getDaysIntervening(LocalDate date1, LocalDate date2) {
        Period intervalPeriod = Period.between(date1, date2);
        return intervalPeriod.getDays();
    }

    private int getDaysIntervening(Date date1, Date date2) {
        LocalDate localDate1 = convertToLocalDateViaInstant(date1);
        LocalDate localDate2 = convertToLocalDateViaInstant(date2);
        Period intervalPeriod = Period.between(localDate1, localDate2);
        return intervalPeriod.getDays();
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private LocalDate getDaysAfter(LocalDate date, int daysAfter) {
        return date.plusDays(daysAfter);
    }
}