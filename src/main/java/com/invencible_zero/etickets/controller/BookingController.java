package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.model.Booking;
import com.invencible_zero.etickets.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/bookings")  // This defines the base path for all endpoints in this controller
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    // This indicates a GET HTTP request
    public List<Booking> findAllBookings() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}") // Path variable for id
    public Booking findBookingById(@PathVariable Integer id) {
        return bookingService.findById(id);
    }

    @GetMapping("/show/{showId}") // Path variable for showId
    public List<Booking> findBookingsByShowId(@PathVariable Integer showId) {
        return bookingService.findByShowId(showId);
    }

    @GetMapping("/customer/{customerId}") // Path variable for customerId
    public List<Booking> findBookingsByCustomerId(@PathVariable Integer customerId) {
        return bookingService.findByCustomerId(customerId);
    }

    @GetMapping("/time/{bookingTime}") // Path variable for bookingTime (consider using a more specific type)
    public List<Booking> findBookingsByBookingTime(@PathVariable Timestamp bookingTime) {
        return bookingService.findByBookingTime(bookingTime);
    }
}
