package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TrainSeatAvailabiltyRepository extends JpaRepository<TrainSeatAvailability,Long> {

    @Query("select max(ta.journeyStartDate) from TrainSeatAvailability ta")
    Date getMaxAvailabilityDate();

    List<TrainSeatAvailability> getAllByTrainIdAndJourneyStartDateAndCoachTypeId(Long trainId, LocalDate journeyDate, Integer coachTypeId);

    List<TrainSeatAvailability> findAllByJourneyStartDateGreaterThanAndJourneyStartDateLessThanEqual(LocalDate date, LocalDate endDate);
}
