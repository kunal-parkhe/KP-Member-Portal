package com.example.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]*$",message = "First name should not be empty and should not contain any numbers or special characters")
	private String firstname;
	
	
	
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]*$",message = "Last name should not be empty and should not contain any numbers or special characters")
	private String lastname;
	
	
	@NotBlank(message = "Email id should not be null")
	@Email(message="Please enter the valid email id")
	private String emailid;
	
	
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=]).{10,}$",message = "Password must contain atleast 1 uppercase,1 lowercase,1 special character and 1 digit.Length must be 10.")
	private String password;
	
	
	private String address;
	
	
	 
	 @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return null;
	    }
	 
	    @Override
	    public String getUsername() {
	        return this.emailid;
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }


	
	
	
	
	
}
