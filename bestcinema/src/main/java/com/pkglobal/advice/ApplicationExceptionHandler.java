package com.pkglobal.advice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pkglobal.exception.RecordNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	

	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	String dateString = localDate.toString();
	String timeString = localTime.toString();

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RecordNotFoundException.class)
    public Map<String, String> handleBusinessException(RecordNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        errorMap.put("Date : ", dateString);
        errorMap.put("Time : ", timeString);
        return errorMap;
    }

}
