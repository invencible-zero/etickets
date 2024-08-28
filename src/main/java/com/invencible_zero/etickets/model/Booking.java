package com.invencible_zero.etickets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seatsBooked;
    private java.sql.Timestamp bookingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showId")
    @JsonBackReference("show-bookings")
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    @JsonBackReference("customer-bookings")
    private Customer customer;
}
