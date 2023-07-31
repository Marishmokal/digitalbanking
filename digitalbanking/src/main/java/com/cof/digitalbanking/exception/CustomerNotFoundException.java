package com.cof.digitalbanking.exception;

public class CustomerNotFoundException extends RuntimeException {
	String message;

	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	

}
