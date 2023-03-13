package com.pkglobal.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5230864204464213771L;

	public RecordNotFoundException(String message) {
		super(message);
	}
	
	
}
