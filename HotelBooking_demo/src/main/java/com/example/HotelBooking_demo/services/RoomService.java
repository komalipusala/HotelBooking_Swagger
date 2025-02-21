package com.example.HotelBooking_demo.services;
import com.example.HotelBooking_demo.model.Room;
import com.example.HotelBooking_demo.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    
    public Room getRoomById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }
    
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
    
    public Room updateRoom(Long id, Room updatedRoom) {
        if (roomRepository.existsById(id)) {
            updatedRoom.setId(id);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }
    
    public boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Room> listRoomsByType(String type) {
        return roomRepository.findByRoomTypeIgnoreCase(type);
    }

    public List<Room> listAvailableRooms(String type, String bedType) {
        return roomRepository.findByRoomTypeIgnoreCaseAndBedTypeIgnoreCaseAndIsAvailableTrue(type, bedType);
    }
}









