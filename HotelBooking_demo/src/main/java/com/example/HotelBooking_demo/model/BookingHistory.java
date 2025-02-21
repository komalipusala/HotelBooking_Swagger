package com.example.HotelBooking_demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @JsonIgnoreProperties("bookingHistories")
    @ManyToOne(cascade = CascadeType.MERGE) 
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate startDate;
    private LocalDate endDate;
}
