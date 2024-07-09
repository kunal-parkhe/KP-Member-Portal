package com.example.exception;

public class CaregiverNotFoundException extends RuntimeException{
	private static final long serialversionUID = 1L;
	
	public CaregiverNotFoundException(String message) {
		super(message);
		
	}

}
