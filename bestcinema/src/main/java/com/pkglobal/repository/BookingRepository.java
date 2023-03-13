package com.pkglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkglobal.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
