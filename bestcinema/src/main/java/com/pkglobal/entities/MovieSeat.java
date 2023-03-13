package com.pkglobal.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movieseat")
public class MovieSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String seatsno;
    private String rowsno;
    private boolean booked;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeatsno() {
		return seatsno;
	}
	public void setSeatsno(String seatsno) {
		this.seatsno = seatsno;
	}
	public String getRowsno() {
		return rowsno;
	}
	public void setRowsno(String rowsno) {
		this.rowsno = rowsno;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
    
    
    

    
    
}