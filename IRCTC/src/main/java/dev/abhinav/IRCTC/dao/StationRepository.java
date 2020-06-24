package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
