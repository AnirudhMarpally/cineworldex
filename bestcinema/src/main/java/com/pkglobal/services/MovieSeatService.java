package com.pkglobal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkglobal.entities.MovieSeat;
import com.pkglobal.repository.MovieSeatRepository;

@Service
public class MovieSeatService {

    @Autowired
    private MovieSeatRepository movieSeatRepository;

    public MovieSeat bookSeat(MovieSeat seat) {
        // check if seat is available for booking
        MovieSeat existingSeat = movieSeatRepository.findBySeatsno(seat.getSeatsno());
        if (existingSeat != null && !existingSeat.isBooked()) {
            throw new IllegalArgumentException("Seat is already booked");
        }
        seat.setBooked(false);
        return movieSeatRepository.save(seat);
    }

    public MovieSeat getSeat(Long id) {
        Optional<MovieSeat> seat = movieSeatRepository.findById(id);
        if (!seat.isPresent()) {
            throw new IllegalArgumentException("Seat not found");
        }
        return seat.get();
    }

    public MovieSeat updateSeat(Long id, MovieSeat seat) {
        MovieSeat existingSeat = getSeat(id);
        existingSeat.setSeatsno(seat.getSeatsno());
        existingSeat.setBooked(seat.isBooked());
        return movieSeatRepository.save(existingSeat);
    }

    public void deleteSeat(Long id) {
        movieSeatRepository.deleteById(id);
    }
}