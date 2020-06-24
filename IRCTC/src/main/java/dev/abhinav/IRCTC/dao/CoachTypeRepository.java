package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.CoachType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachTypeRepository extends JpaRepository<CoachType, Integer> {
}
