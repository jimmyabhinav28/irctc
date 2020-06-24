package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.Train;
import dev.abhinav.IRCTC.entity.TrainCoachRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {

//    @Query(value="select new dev.abhinav.IRCTC.dao.TrainCoachSeats(tc.train.id,tc.train.name,ct.id,tc.coachIdentifier,ct.coachClass,count(*),sum(ct.totalSeats),sum(ct.windowSeats),sum(ct.aisleSeats)) from TrainCoachRecord tc, CoachType ct where tc.coachType.id=ct.id and tc.train.id=?1 group by tc.coachType.id")
//    List<TrainCoachRecord> getTrainCoachSeatDetails(Long trainId);
}
