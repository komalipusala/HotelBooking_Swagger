package com.example.HotelBooking_demo.upcomingbookingDTO;
import lombok.Data;
import java.time.LocalDate;
@Data
public class UpcomingBookingResponseDTO {
    private Long id;
    private Long customerId;
    private String customerName;
    private LocalDate startDate;
    private String roomType;
    private String bedType;
    private int numberOfRooms;
}