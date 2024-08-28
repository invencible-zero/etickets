package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Timestamp;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByBookingTime(Timestamp bookingTime);
    List<Booking> findByShowId(Integer showId);
    List<Booking> findByCustomerId(Integer customerId);
}
