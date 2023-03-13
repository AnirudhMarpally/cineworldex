 package com.pkglobal.controller;

import java.util.List;
import java.util.Optional;

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

import com.pkglobal.entities.Showtime;
import com.pkglobal.exception.RecordNotFoundException;
import com.pkglobal.services.ShowtimeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {
	
    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping("/add")
    public ResponseEntity<Showtime> addShowtime(@RequestBody Showtime showtime) {
    	return new ResponseEntity<>(showtimeService.saveShowtime(showtime), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Showtime> updateShowtime(@RequestBody Showtime showtime) {
    	return new ResponseEntity<>(showtimeService.updateShowtime(showtime), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{showtimeId}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable int showtimeId) {
    	showtimeService.deleteShowtime(showtimeId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
    	return ResponseEntity.ok(showtimeService.getAllShowtimes());
    }

    @GetMapping("/{showtimeId}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable int showtimeId) 
    		throws RecordNotFoundException {
    	return ResponseEntity.ok(showtimeService.getShowtimeById(showtimeId));
    }
    
    @GetMapping("/ShowsByTheatreAndMovie/{theatreId}/{movieId}")
    public ResponseEntity<List<Showtime>> getShowsByTheatreAndMovie(
    		@PathVariable int theatreId, 
    		@PathVariable int movieId) throws RecordNotFoundException{
    	return new ResponseEntity<>(showtimeService.getShowsByTheatreAndMovie(theatreId, movieId), HttpStatus.OK);
    }
    
    @GetMapping("/ShowsByMovie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowsByMovie(@PathVariable int movieId) 
    		throws RecordNotFoundException{
    	return ResponseEntity.ok(showtimeService.getShowsByMovie(movieId));
    }
    
    @GetMapping("/Day/{day}")
    public ResponseEntity<List<Showtime>> getShowsByDay(@PathVariable String day) 
    		throws RecordNotFoundException{
    	return ResponseEntity.ok(showtimeService.getShowsByDay(day));
    }
    
    @GetMapping("/Time/{time}")
    public ResponseEntity<List<Showtime>> getShowsByTime( @PathVariable String time) 
    		throws RecordNotFoundException{
    	return ResponseEntity.ok(showtimeService.getShowsByTime(time));
    }
    
    
}