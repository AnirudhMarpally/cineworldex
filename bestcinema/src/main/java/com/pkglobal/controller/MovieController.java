package com.pkglobal.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.pkglobal.entities.Movie;
import com.pkglobal.exception.RecordNotFoundException;
import com.pkglobal.services.MovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    
    
    @PostMapping("/add")
    public ResponseEntity<Movie> saveMovie(@RequestBody @Valid Movie movie){
        return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }
    
    
    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovie(@RequestBody @Valid Movie movie){
    	return new ResponseEntity<>(movieService.updateMovie(movie), HttpStatus.OK);
    }

    

    
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
    	movieService.deleteMovie(movieId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }	  
    
    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) throws RecordNotFoundException {
    	return ResponseEntity.ok(movieService.getMovieById(movieId));
    }
    
    @GetMapping("/moviesInTheatre/{theatreId}")
    public ResponseEntity<List<Movie>> getMoviesByTheatre(@PathVariable int theatreId) throws RecordNotFoundException {
    	return ResponseEntity.ok(movieService.getMoviesByTheatre(theatreId));
    }
    
}