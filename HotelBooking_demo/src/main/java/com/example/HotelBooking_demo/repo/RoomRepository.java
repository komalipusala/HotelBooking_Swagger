package com.example.HotelBooking_demo.repo;
import com.example.HotelBooking_demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByRoomTypeIgnoreCase(String type);
    List<Room> findByRoomTypeIgnoreCaseAndBedTypeIgnoreCaseAndIsAvailableTrue(String type, String bedType);
    List<Room> findByStatusIgnoreCase(String status);
    Room findByRoomNumber(String roomNumber);
}