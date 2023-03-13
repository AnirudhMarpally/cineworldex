package com.pkglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pkglobal.entities.Movie;
import com.pkglobal.entities.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	Theatre findByTheatreId(int theatreId);
	

	

}
