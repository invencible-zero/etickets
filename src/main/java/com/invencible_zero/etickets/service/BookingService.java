package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.model.Booking;
import com.invencible_zero.etickets.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> findAll() {
        log.info("Finding all bookings");
        return bookingRepository.findAll();
    }

    public Booking findById(Integer id) {
        log.info("Finding booking by id: {}", id);
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> findByShowId(Integer showId) {
        log.info("Finding bookings by show id: {}", showId);
        return bookingRepository.findByShowId(showId);
    }

    public List<Booking> findByCustomerId(Integer customerId) {
        log.info("Finding bookings by customer id: {}", customerId);
        return bookingRepository.findByCustomerId(customerId);
    }

    public List<Booking> findByBookingTime(Timestamp bookingTime) {
        log.info("Finding bookings by booking time: {}", bookingTime);
        return bookingRepository.findByBookingTime(bookingTime);
    }
}
