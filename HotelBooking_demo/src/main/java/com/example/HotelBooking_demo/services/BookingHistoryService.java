package com.example.HotelBooking_demo.services;

import com.example.HotelBooking_demo.model.BookingHistory;
import com.example.HotelBooking_demo.model.Customer;
import com.example.HotelBooking_demo.model.Room;
import com.example.HotelBooking_demo.repo.BookingHistoryRepository;
import com.example.HotelBooking_demo.repo.CustomerRepo;
import com.example.HotelBooking_demo.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingHistoryService {

    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepo customerRepository;

    public BookingHistory createBooking(Long customerId, Long roomId, LocalDate startDate, LocalDate endDate) {

        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));


        BookingHistory bookingHistory = new BookingHistory();
        bookingHistory.setCustomer(existingCustomer);
        bookingHistory.setRoom(existingRoom);
        bookingHistory.setStartDate(startDate);
        bookingHistory.setEndDate(endDate);


        return bookingHistoryRepository.save(bookingHistory);
    }
}
