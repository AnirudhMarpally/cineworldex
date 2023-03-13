package com.pkglobal.controller;

import java.util.List;
import java.util.Optional;

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

import com.pkglobal.entities.Theatre;
import com.pkglobal.exception.RecordNotFoundException;
import com.pkglobal.services.TheatreService;

@CrossOrigin("*")
@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<Theatre> addTheatre(@RequestBody @Valid Theatre theatre) {
        return new ResponseEntity<>(theatreService.saveTheatre(theatre) , HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Theatre> updateTheatre(@RequestBody @Valid Theatre theatre) {
    	return new ResponseEntity<>(theatreService.updateTheatre(theatre), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{theatreId}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable int theatreId) {
    	theatreService.deleteTheatre(theatreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable int theatreId) throws RecordNotFoundException {
    	return ResponseEntity.ok(theatreService.getTheatreById(theatreId));
    }
    
    
}
