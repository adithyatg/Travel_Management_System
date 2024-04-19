package com.example.demo.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

<<<<<<< HEAD

@Entity
public class Bookings{

=======
@Entity
public class Bookings {
>>>>>>> origin/main
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    
    // private int userId;
    private int flightId;
    private LocalDate bookingDate;
    private String status;
    private float totalPrice;
    private boolean discountApplied;
<<<<<<< HEAD


=======
>>>>>>> origin/main
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

<<<<<<< HEAD
=======

>>>>>>> origin/main
    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

<<<<<<< HEAD
    public void setUser(Users user){
        this.user=user;
    }

    public int getUser(){
        return user.getUserId();
    }

=======
>>>>>>> origin/main
    public int getUserId() {
        return user.getUserId();
    }

    public void setUserId(int userId) {
        user.setUserId(userId);
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public boolean isDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(boolean discountApplied) {
        this.discountApplied = discountApplied;
    }
<<<<<<< HEAD

}
=======
}


>>>>>>> origin/main
