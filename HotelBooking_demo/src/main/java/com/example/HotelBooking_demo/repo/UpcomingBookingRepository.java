package com.example.HotelBooking_demo.repo;
import com.example.HotelBooking_demo.model.UpcomingBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface UpcomingBookingRepository extends JpaRepository<UpcomingBooking, Long> {
    List<UpcomingBooking> findByStartDateAfter(LocalDate date);
    List<UpcomingBooking> findByCustomerId(Long customerId);
    List<UpcomingBooking> findByRoomTypeIgnoreCase(String roomType);
    List<UpcomingBooking> findByRoomTypeIgnoreCaseAndBedTypeIgnoreCase(String roomType, String bedType);
    
}