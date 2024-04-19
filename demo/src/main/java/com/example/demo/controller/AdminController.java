package com.example.demo.controller;

import com.example.demo.model.Bookings;
import com.example.demo.model.Flight;
import com.example.demo.model.Person;
import com.example.demo.model.Users;
import com.example.demo.service.AdminService;
import com.example.demo.service.BookingService;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import com.example.demo.service.FlightService;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
>>>>>>> origin/main

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired    
    private BookingService bookingService;
    @Autowired
    private PersonService personService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<Users> users = adminService.getAllUsers();
        List<Person> persons = adminService.getAllPersons();
        List<Bookings> bookings = adminService.getAllBookings();
        List<Flight> flights = adminService.getAllFlights();

        model.addAttribute("users", users);
        model.addAttribute("persons", persons);
        model.addAttribute("bookings", bookings);
        model.addAttribute("flights", flights);

        return "admin";
    }
    @DeleteMapping("/delete{type}/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable String type, @PathVariable int id) {
        switch (type) {
            case "user":
                userService.deleteUser(id);
                break;
            case "person":
                personService.deletePerson(id);
                break;
            case "booking":
                bookingService.deleteBooking(id);
                break;
            case "flight":
                flightService.deleteFlight(id);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid type provided");
        }
        return ResponseEntity.ok("Entry deleted successfully");
    }
<<<<<<< HEAD

    @PostMapping("/addFlight")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @PostMapping("/modifyBooking")
    public ResponseEntity<String> modifyBooking(@RequestBody Bookings booking) {
        // Get the booking by ID from the database
        Bookings existingBooking = bookingService.getBookingById(booking.getBookingId());
        if (existingBooking == null) {
            return ResponseEntity.badRequest().body("Booking not found");
        }
        // Update booking details
        existingBooking.setBookingDate(booking.getBookingDate());
        existingBooking.setFlightId(booking.getFlightId());
        existingBooking.setStatus(booking.getStatus());
        // Save the updated booking
        bookingService.saveBooking(existingBooking);
        return ResponseEntity.ok("Booking modified successfully");
    }
=======
>>>>>>> origin/main
}