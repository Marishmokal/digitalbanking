package com.cof.digitalbanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handleException(CustomerNotFoundException exception)
	{
		ExceptionResponse response=new ExceptionResponse("Not found customer",exception.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value=InvalidDetailsException.class)
	public ResponseEntity<ExceptionResponse>ExceptionHandle(InvalidDetailsException e)
	{
		ExceptionResponse res=new ExceptionResponse("Invalid details",e.getLocalizedMessage());
		return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
		
	}
}
