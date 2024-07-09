package com.example.service;

import java.util.List;

import com.example.model.Caregiver;
import com.example.model.CaregiverDTO;


public interface CaregiverService {

	public Caregiver fetchById(Integer id);
	
	public List<Caregiver> fetchByFirstname(String firstname);
	
	public List<Caregiver> fetchByLastname(String lastname);
	
	public List<Caregiver> fetchByEmailid(String emailid);
	
	public CaregiverDTO getCaregiver(Integer caregiverid) throws Exception;
	public List<Caregiver> getAllCaregiver() throws Exception;
	
}
