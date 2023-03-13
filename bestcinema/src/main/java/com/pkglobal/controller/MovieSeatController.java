package com.pkglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkglobal.entities.MovieSeat;
import com.pkglobal.services.MovieSeatService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/seats")
public class MovieSeatController {

    @Autowired
    private MovieSeatService movieSeatService;

    @PostMapping("/book")
    public ResponseEntity<MovieSeat> bookSeat(@RequestBody MovieSeat seat) {
        MovieSeat bookedSeat = movieSeatService.bookSeat(seat);
        return new ResponseEntity<>(bookedSeat, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieSeat> getSeat(@PathVariable Long id) {
        MovieSeat seat = movieSeatService.getSeat(id);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieSeat> updateSeat(@PathVariable Long id, @RequestBody MovieSeat seat) {
        MovieSeat updatedSeat = movieSeatService.updateSeat(id, seat);
        return new ResponseEntity<>(updatedSeat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        movieSeatService.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}