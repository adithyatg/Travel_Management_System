package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
<<<<<<< HEAD
public class FlightService{
=======
public class FlightService {
>>>>>>> origin/main

    @Autowired
    private FlightRepository flightRepository;

<<<<<<< HEAD

=======
>>>>>>> origin/main
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(int id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }
<<<<<<< HEAD
    public void updateAvailableSeats(int flightId){
        Flight flight=flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);  

        flightRepository.save(flight);
    }
=======
>>>>>>> origin/main
}
