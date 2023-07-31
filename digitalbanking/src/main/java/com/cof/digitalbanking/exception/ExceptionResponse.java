package com.cof.digitalbanking.exception;

public class ExceptionResponse {
	private String message;
	private String errorMessage;
	
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	ExceptionResponse(String message, String errorMessage) {
		super();
		this.message = message;
		this.errorMessage = errorMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	



}
