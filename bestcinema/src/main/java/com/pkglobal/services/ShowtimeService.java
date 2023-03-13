package com.pkglobal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkglobal.entities.Showtime;
import com.pkglobal.entities.Theatre;
import com.pkglobal.exception.RecordNotFoundException;
import com.pkglobal.repository.ShowtimeRepository;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public Showtime saveShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public Showtime updateShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public void deleteShowtime(int showtimeId) {
        showtimeRepository.deleteById(showtimeId);
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime getShowtimeById(int showtimeId) throws RecordNotFoundException {
        Showtime showtime = showtimeRepository.findByShowtimeId(showtimeId);
        if (showtime!=null) {
			return showtime;
		}else {
			throw new RecordNotFoundException("No Shows found for showtimeId : " + showtimeId);
		}
    }

	public List<Showtime> getShowsByTheatreAndMovie(int theatreId, int movieId) 
			throws RecordNotFoundException {
		List<Showtime> showtime = showtimeRepository.getShowsByTheatreAndMovie(theatreId,movieId);
		if (showtime!=null) {
			return showtime;
		}else {
			throw new RecordNotFoundException("There are no Shows for theatreId : " + theatreId + "and movieId" + movieId);
		}
	}

	public List<Showtime> getShowsByMovie(int movieId) throws RecordNotFoundException {
		List<Showtime> showtime = showtimeRepository.getShowsByMovie(movieId);
		if (showtime!=null) {
			return showtime;
		}else {
			throw new RecordNotFoundException("There are no Shows for movieId : " + movieId);
		}
	}

	public List<Showtime> getShowsByDay(String day) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		List<Showtime> showtime = showtimeRepository.getShowsByDay(day);
		if (showtime!=null) {
			return showtime;
		}else {
			throw new RecordNotFoundException("No Shows screening on " + day);
		}
	}

	public List<Showtime> getShowsByTime (String time) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		List<Showtime> showtime = showtimeRepository.getShowsByTime(time);
		if (showtime!=null) {
			return showtime;
		}else {
			throw new RecordNotFoundException("No Shows screening at " + time);
		}
	}
}