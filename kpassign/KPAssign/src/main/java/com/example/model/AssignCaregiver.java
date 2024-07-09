package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.Data;

@Entity
@Data
public class AssignCaregiver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer memberId;
	Integer careGiverId;
	String Firstname;
	String Lastname;
	String Emailid;

}
