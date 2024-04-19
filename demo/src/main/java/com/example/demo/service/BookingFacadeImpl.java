package com.example.demo.service;

import com.example.demo.model.Bookings;
import com.example.demo.model.Flight;
import com.example.demo.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingFacadeImpl implements BookingFacade {

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Override
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights(); // You can sort this list as needed
    }

    @Override
    public Flight getFlightById(int id) {
        return flightService.getFlightById(id);
    }

    @Override
    public boolean confirmBooking(int userId, int flightId) {
        try {
            bookFlight(userId, flightId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void bookFlight(int userId, int flightId) {
        // Check availability, create booking, and update available seats
        Flight flight = flightService.getFlightById(flightId);
        Users user=userService.getUserById(userId);

        if (flight.getAvailableSeats() > 0) {
            // Create booking
            Bookings booking = new Bookings();
            booking.setUser(user);
            booking.setFlightId(flightId);

            LocalDate today=LocalDate.now();
            booking.setBookingDate(today);
            booking.setStatus("confirmed");
            
            bookingService.saveBooking(booking);

            // Update available seats
            flightService.updateAvailableSeats(flightId);
        } else {
            throw new RuntimeException("No available seats for this flight");
        }
    }

    @Override
    public void cancelBooking(int bookingId) {
        // Cancel booking and update available seats
        Bookings booking = bookingService.getBookingById(bookingId);
        if (booking != null && booking.getStatus().equals("Confirmed")) {
            booking.setStatus("Cancelled");
            bookingService.saveBooking(booking);

            // Update available seats
            Flight flight = flightService.getFlightById(booking.getFlightId());
            flight.setAvailableSeats(flight.getAvailableSeats() + 1);
            flightService.saveFlight(flight);
        } else {
            throw new RuntimeException("Booking not found or already cancelled");
        }
    }
}
