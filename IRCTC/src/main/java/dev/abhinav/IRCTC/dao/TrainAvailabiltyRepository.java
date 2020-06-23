package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.TrainAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainAvailabiltyRepository extends JpaRepository<TrainAvailability,Long> {
}
