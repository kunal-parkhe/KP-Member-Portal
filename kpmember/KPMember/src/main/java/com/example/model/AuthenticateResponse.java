package com.example.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
public class AuthenticateResponse {
	private int id;
	private String email;
	private String firstname;
	private String lastname;
	private String address;
    private String accessToken;
    private boolean isValid;
	public AuthenticateResponse(Integer id,String email, String firstname, String lastname, String address, String accessToken,boolean isValid) {
		this.id=id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.accessToken = accessToken;
		this.isValid=isValid;
	}
	public AuthenticateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
 
    

	

}
