package com.pkglobal.repository;

import org.springframework.data.repository.CrudRepository;

import com.pkglobal.entities.MovieSeat;

public interface MovieSeatRepository extends CrudRepository<MovieSeat, Long> {

	MovieSeat findBySeatsno(String seatsno);

}
