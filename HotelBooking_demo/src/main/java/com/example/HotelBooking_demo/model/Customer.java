package com.example.HotelBooking_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")  
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Column(nullable = false, unique = true)
    private String mobile;

    @NotBlank(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore  
    @ToString.Exclude
    private List<BookingHistory> bookingHistories;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore  
    @ToString.Exclude
    private List<UpcomingBooking> upcomingBookings;

  
    @PrePersist
    @PreUpdate
    private void validateCustomer() {
        this.email = this.email.toLowerCase().trim();
        this.mobile = this.mobile.trim(); 
    }

    public static Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
    
        throw new UnsupportedOperationException("Unimplemented method 'withDefaults'");
    }
}
