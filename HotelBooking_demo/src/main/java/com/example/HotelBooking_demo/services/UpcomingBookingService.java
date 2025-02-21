package com.example.HotelBooking_demo.services;
import com.example.HotelBooking_demo.upcomingbookingDTO.UpcomingBookingRequestDTO;
import com.example.HotelBooking_demo.upcomingbookingDTO.UpcomingBookingResponseDTO;
import com.example.HotelBooking_demo.model.Customer;
import com.example.HotelBooking_demo.model.UpcomingBooking;
import com.example.HotelBooking_demo.repo.CustomerRepo;
import com.example.HotelBooking_demo.repo.UpcomingBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UpcomingBookingService {
    @Autowired
    private UpcomingBookingRepository upcomingBookingRepository;
    @Autowired
    private CustomerRepo customerRepository;
    @Transactional
    public UpcomingBookingResponseDTO createBooking(UpcomingBookingRequestDTO requestDTO) {
        
        Customer existingCustomer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    
        UpcomingBooking upcomingBooking = new UpcomingBooking();
        upcomingBooking.setCustomer(existingCustomer);
        upcomingBooking.setStartDate(requestDTO.getStartDate());
        upcomingBooking.setRoomType(requestDTO.getRoomType());
        upcomingBooking.setBedType(requestDTO.getBedType());
        upcomingBooking.setNumberOfRooms(requestDTO.getNumberOfRooms());
        
        upcomingBooking = upcomingBookingRepository.save(upcomingBooking);
        return convertToDTO(upcomingBooking);
    }
    public List<UpcomingBookingResponseDTO> getAllBookings() {
        return upcomingBookingRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public UpcomingBookingResponseDTO getBookingById(Long id) {
        UpcomingBooking upcomingBooking = upcomingBookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return convertToDTO(upcomingBooking);
    }
    @Transactional
    public void deleteBooking(Long id) {
        upcomingBookingRepository.deleteById(id);
    }
    private UpcomingBookingResponseDTO convertToDTO(UpcomingBooking booking) {
        UpcomingBookingResponseDTO dto = new UpcomingBookingResponseDTO();
        dto.setId(booking.getId());
        dto.setCustomerId(booking.getCustomer().getId());
        dto.setCustomerName(booking.getCustomer().getName());
        dto.setStartDate(booking.getStartDate());
        dto.setRoomType(booking.getRoomType());
        dto.setBedType(booking.getBedType());
        dto.setNumberOfRooms(booking.getNumberOfRooms());
        return dto;
    }
}


















