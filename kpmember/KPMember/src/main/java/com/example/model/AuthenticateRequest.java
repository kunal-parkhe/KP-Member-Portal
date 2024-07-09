package com.example.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
 
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuthenticateRequest {
	    @NotNull @Email 
	    private String email;
	     
	    @NotNull @Length(min = 5, max = 10)
	    private String password;
	 

}
