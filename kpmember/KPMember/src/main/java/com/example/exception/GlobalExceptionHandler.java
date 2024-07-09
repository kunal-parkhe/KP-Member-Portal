package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MailAlreadyExistException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleMailAlreadyExistException(MailAlreadyExistException ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
	}
	
	@ExceptionHandler(value = ValidCredentialException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleValidCredentialException(ValidCredentialException ex)
	{
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(value= CaregiverNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleCaregiverNotFoundException(CaregiverNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}

}