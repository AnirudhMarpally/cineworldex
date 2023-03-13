package com.pkglobal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkglobal.entities.Theatre;
import com.pkglobal.exception.RecordNotFoundException;
import com.pkglobal.repository.TheatreRepository;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(int theatreId) {
        theatreRepository.deleteById(theatreId);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(int theatreId) throws RecordNotFoundException {
    	Theatre theatre = theatreRepository.findByTheatreId(theatreId);
        if (theatre!=null) {
			return theatre;
		}else {
			throw new RecordNotFoundException("Theatre not found for theatreId : " + theatreId);
		}
    }

	
}
