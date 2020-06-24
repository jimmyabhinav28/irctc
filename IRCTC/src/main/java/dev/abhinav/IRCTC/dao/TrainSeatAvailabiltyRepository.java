package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.TrainSeatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TrainAvailabiltyRepository extends JpaRepository<TrainSeatAvailability,Long> {

    @Query("select max(ta.journeyStartDate) from TrainAvailability ta")
    Date getMaxAvailabilityDate();
}
