package com.example.demo.controller;

<<<<<<< HEAD
import com.example.demo.model.Flight;
import com.example.demo.service.BookingFacadeImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingFacadeImpl bookingFacade;


    @GetMapping("/bookFlight")
    public String showBookFlightForm(Model model) {
        model.addAttribute("flight", new Flight());
        return "bookFlight";
    }

    @GetMapping("/select")
    public String showSelectFlightPage(Model model) {
        List<Flight> sortedFlights = (List<Flight>) model.getAttribute("flights");
        System.out.println("****************************************************");
        System.out.println(sortedFlights);
        if(sortedFlights != null && !sortedFlights.isEmpty()) {
            return "select";
        }
        return "redirect:/bookFlight";
    }
    

    @PostMapping("/bookFlight")
    public String bookFlight(@RequestParam String source, @RequestParam String destination, @RequestParam String flightType,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date departureDate,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date returnDate, Model model) {
        List<Flight> flights = bookingFacade.getAllFlights();

        List<Flight> pq0 = new ArrayList<>();
        List<Flight> pq1 = new ArrayList<>();
        List<Flight> pq2 = new ArrayList<>();
        List<Flight> pq3 = new ArrayList<>();
        List<Flight> pq4 = new ArrayList<>();

        for (Flight flight : flights) {
            String src = flight.getSource().toLowerCase();
            String dest = flight.getDestination().toLowerCase();
            Date dep = flight.getDepartureDate();
            Date ret = (returnDate != null) ? flight.getReturnDate() : null;

            if (src.equals(source)) {
                if (dest.equals(destination)) {
                    if (dep.equals(departureDate)) {
                        if (ret == null || ret.equals(returnDate)) {
                            pq4.add(flight);
                        } else pq3.add(flight);
                    } else pq2.add(flight);
                } else pq1.add(flight);
            } else pq0.add(flight);
        }

        List<Flight> mergedList = new ArrayList<>();
        mergedList.addAll(pq3);
        mergedList.addAll(pq2);
        mergedList.addAll(pq1);
        mergedList.addAll(pq0);
        mergedList.addAll(pq4);

        model.addAttribute("sortedFlights", mergedList);
    
        return "select";
    
    }

    @GetMapping("/finalBook/{id}")
    public String bookFlight(@PathVariable int id,Model model){
        Flight flights = bookingFacade.getFlightById(id);
        model.addAttribute("flight", flights);
        return "finalBook";
    }

    @PostMapping("/confirmBooking")
    public String confirmBooking(@RequestParam int flightId, @RequestParam int userId, RedirectAttributes redirectAttributes) {

        bookingFacade.bookFlight(userId, flightId);

        redirectAttributes.addFlashAttribute("userId", userId);
        return "redirect:/home";
    }



=======
import com.example.demo.model.Bookings;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Bookings> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Bookings getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Bookings saveBooking(@RequestBody Bookings booking) {
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
>>>>>>> origin/main
}
