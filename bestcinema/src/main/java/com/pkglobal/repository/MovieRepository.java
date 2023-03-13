package com.pkglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pkglobal.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query(value = "SELECT DISTINCT movie.movie_id,movie.title,movie.description,movie.language,movie.image,movie.genre FROM movie,showtime,theatre WHERE movie.movie_id=showtime.movie_fk and showtime.theatre_fk=:theatreId",nativeQuery = true)
	List<Movie> findMoviesByTheatre(int theatreId);

	Movie findByMovieId(int movieId);

}
