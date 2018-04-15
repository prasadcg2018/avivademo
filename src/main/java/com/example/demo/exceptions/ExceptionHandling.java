package com.example.demo.exceptions;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	
	private Logger logger = Logger.getLogger("ExceptionHandling");
	
	@ExceptionHandler(value=ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<?> arrayBoundaryException(Exception e){
		logger.info("ArrayIndexOutOfBoundsException "+e.getMessage());
		return new ResponseEntity<String>("Please check inputs parameters",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<?> exception(Exception e){
		logger.info("Exception "+e.getMessage());
		return new ResponseEntity<String>("Please give valid API request",HttpStatus.BAD_REQUEST);
	}
	
}
