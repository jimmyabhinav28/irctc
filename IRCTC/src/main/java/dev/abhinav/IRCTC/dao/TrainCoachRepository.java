package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.TrainCoachRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainCoachRepository extends JpaRepository<TrainCoachRecord,Long> {
}
