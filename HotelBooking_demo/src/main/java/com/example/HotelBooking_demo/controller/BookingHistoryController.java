package com.example.HotelBooking_demo.controller;

import com.example.HotelBooking_demo.model.BookingHistory;
import com.example.HotelBooking_demo.services.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/booking-history")
public class BookingHistoryController {

    @Autowired
    private BookingHistoryService bookingHistoryService;

    @PostMapping("/create")
    public BookingHistory createBooking(@RequestBody Map<String, Object> request) {
        Long customerId = Long.valueOf(request.get("customerId").toString());
        Long roomId = Long.valueOf(request.get("roomId").toString());
        LocalDate startDate = LocalDate.parse(request.get("startDate").toString());
        LocalDate endDate = LocalDate.parse(request.get("endDate").toString());

        return bookingHistoryService.createBooking(customerId, roomId, startDate, endDate);
    }
}
