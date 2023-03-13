package com.pkglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pkglobal.entities.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

	@Query(value = "SELECT * FROM movie,theatre,showtime WHERE movie.movie_id=showtime.movie_fk AND showtime.theatre_fk=theatre.theatre_id and showtime.movie_fk= :movieId and theatre.theatre_id=:theatreId",nativeQuery = true)
	List<Showtime> getShowsByTheatreAndMovie(int theatreId, int movieId);

	@Query(value = "SELECT * FROM movie,showtime WHERE movie.movie_id=showtime.movie_fk and showtime.movie_fk= :movieId",nativeQuery = true)
	List<Showtime> getShowsByMovie(int movieId);

	@Query(value = "SELECT * FROM showtime,theatre,movie WHERE showtime.theatre_fk=theatre.theatre_id and showtime.movie_fk=movie.movie_id and showtime.day=:day",nativeQuery = true)
	List<Showtime> getShowsByDay(String day);

	@Query(value = "SELECT * FROM showtime,theatre,movie WHERE showtime.theatre_fk=theatre.theatre_id and showtime.movie_fk=movie.movie_id and showtime.TIME=:time",nativeQuery = true)
	List<Showtime> getShowsByTime(String time);

	Showtime findByShowtimeId(int showtimeId);


}
