package com.example.HotelBooking_demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HotelBooking_demo.model.Customer;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}





