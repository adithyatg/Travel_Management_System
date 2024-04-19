package com.example.demo.service;

import com.example.demo.model.Flight;
import java.util.List;

public interface BookingFacade {
    List<Flight> getAllFlights();
    Flight getFlightById(int id);
    boolean confirmBooking(int userId, int flightId);
    void bookFlight(int userId, int flightId);
    void cancelBooking(int bookingId);
}
