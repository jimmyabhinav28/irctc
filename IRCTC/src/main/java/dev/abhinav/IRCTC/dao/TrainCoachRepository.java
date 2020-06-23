package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.Train;
import dev.abhinav.IRCTC.entity.TrainCoachRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainCoachRepository extends JpaRepository<TrainCoachRecord,Long> {

    List<TrainCoachRecord> getAllByTrain(Train train);
}
