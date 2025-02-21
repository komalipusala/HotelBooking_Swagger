package com.example.HotelBooking_demo.model;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "upcoming_bookings")
public class UpcomingBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "room_type", nullable = false)
    private String roomType;
    @Column(name = "bed_type", nullable = false)
    private String bedType;
    @Column(name = "number_of_rooms", nullable = false)
    @Min(1)
    private int numberOfRooms;
}





