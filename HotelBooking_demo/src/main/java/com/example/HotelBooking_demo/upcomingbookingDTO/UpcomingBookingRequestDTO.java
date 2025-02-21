package com.example.HotelBooking_demo.upcomingbookingDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
@Data
public class UpcomingBookingRequestDTO {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    @NotNull(message = "Room type is required")
    private String roomType;
    @NotNull(message = "Bed type is required")
    private String bedType;
    @Min(value = 1, message = "Number of rooms must be at least 1")
    private int numberOfRooms;
}