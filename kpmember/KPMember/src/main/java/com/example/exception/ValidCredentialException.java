package com.example.exception;

public class ValidCredentialException extends RuntimeException {

	private static final long serialVersionUId = 1L;
	
	public ValidCredentialException(String message) {
		super(message);
	}
}
