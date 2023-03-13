package com.pkglobal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkglobal.entities.Movie;
import com.pkglobal.exception.RecordNotFoundException;
import com.pkglobal.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int movieId) throws RecordNotFoundException {
        Movie movie = movieRepository.findByMovieId(movieId);
        if (movie!=null) {
			return movie;
		}
        else {
			throw new RecordNotFoundException("Movie not found for id : " + movieId);
		}
        
    }

	public List<Movie> getMoviesByTheatre(int theatreId) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		List<Movie> movie = movieRepository.findMoviesByTheatre(theatreId);
		if (!movie.isEmpty()) {
			return movie;
		}
        else {
			throw new RecordNotFoundException("Movies are not found for theatreId : " + theatreId );
		}
	}
}
