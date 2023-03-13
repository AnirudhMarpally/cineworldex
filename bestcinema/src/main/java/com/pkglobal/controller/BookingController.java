package com.pkglobal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkglobal.entities.Booking;
import com.pkglobal.services.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/delete/{bookingId}")
    public void deleteBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }
}
