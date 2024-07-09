package com.example.model;

import lombok.Data;

@Data
public class AssignCaregiverDTO {
	Integer id;
	Integer memberId;
	Integer careGiverId;
	String Firstname;
	String Lastname;
	String Emailid;

}
