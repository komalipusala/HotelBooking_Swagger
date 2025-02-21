package com.example.HotelBooking_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.HotelBooking_demo")  // Ensure Spring scans the correct package
public class HotelBookingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingDemoApplication.class, args);
        System.out.println("Hotel Booking Application Started Successfully!");
    }
}
