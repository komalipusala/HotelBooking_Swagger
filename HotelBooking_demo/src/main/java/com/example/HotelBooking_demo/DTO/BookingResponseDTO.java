package com.example.HotelBooking_demo.DTO;

import java.time.LocalDate;
public class BookingResponseDTO {
    private Long bookingId;
    private String customerName;
    private String roomNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    public BookingResponseDTO(Long bookingId, String customerName, String roomNumber, LocalDate startDate, LocalDate endDate) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.startDate = startDate;
    }
    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}