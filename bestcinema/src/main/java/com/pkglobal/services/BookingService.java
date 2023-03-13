package com.pkglobal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkglobal.entities.Booking;
import com.pkglobal.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId);
    }
}
