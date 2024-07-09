package com.example.exception;

public class MemberNotFoundException extends RuntimeException {
	private static final long serialVersionUId = 1L;

	public MemberNotFoundException(String message) {
		super(message);
	}
	

}
