package com.example.model;



import lombok.Data;

@Data
public class MemberDTO {

	private Integer id;
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	private String address;
}
