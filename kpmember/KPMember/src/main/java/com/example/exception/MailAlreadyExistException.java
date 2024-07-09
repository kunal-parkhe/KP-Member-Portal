package com.example.exception;

public class MailAlreadyExistException extends RuntimeException{

	private static final long serialVersionUId = 1L;
	
	public MailAlreadyExistException(String message) {
		super(message);
	}
}
