package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.PassengerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTypeRepository extends JpaRepository<PassengerType, Integer> {

}
