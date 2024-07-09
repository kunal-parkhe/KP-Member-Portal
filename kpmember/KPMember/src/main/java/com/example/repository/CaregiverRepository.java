package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Caregiver;

import java.util.List;


@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer>{
	
	public List<Caregiver> findByFirstname(String firstName);
	
	public List<Caregiver> findByLastname(String lastName);
	
	public List<Caregiver> findByEmailid(String emailId);
	

}
