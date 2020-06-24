package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
