package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TrainSeatAvailabiltyRepository extends JpaRepository<TrainSeatAvailability, Long> {

    @Query("select max(ta.journeyStartDate) from TrainSeatAvailability ta")
    Date getMaxAvailabilityDate();

//    @Lock(LockModeType.PESSIMISTIC_READ)
    List<TrainSeatAvailability> getAllByTrainIdAndJourneyStartDateAndCoachTypeId(Long trainId, LocalDate journeyDate, Integer coachTypeId);

//    @Lock(LockModeType.NONE)
    List<TrainSeatAvailability> findAllByJourneyStartDateGreaterThanAndJourneyStartDateLessThanEqual(LocalDate date, LocalDate endDate);

//    @Transactional(Transactional.TxType.REQUIRES_NEW)
//    @Query(value = "update TrainSeatAvailability s set s.seatsAvailable=?2, s.windowSeatsAvailable=?3,s.aisleSeatsAvailable=?4,s.windowSeatsBookingMap=?5,s.aisleSeatsBookingMap=?6 where s.id=?1")
//    void updateAvailability(Long id, Integer seatsAvailable, Integer windowSeatsAvailable, Integer aisleSeatsAvailable, String windowSeatsBookingMap, String aisleSeatsBookingMap);
}
