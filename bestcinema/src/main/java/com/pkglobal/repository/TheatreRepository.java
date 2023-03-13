package com.pkglobal.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pkglobal.entities.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	Theatre findByTheatreId(int theatreId);
	

	

}
