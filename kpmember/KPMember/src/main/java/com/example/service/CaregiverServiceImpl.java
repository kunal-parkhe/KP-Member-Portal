package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CaregiverNotFoundException;
import com.example.model.Caregiver;
import com.example.model.CaregiverDTO;
import com.example.model.Member;
import com.example.model.MemberDTO;
import com.example.repository.CaregiverRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CaregiverServiceImpl implements CaregiverService {
	
	@Autowired
	private CaregiverRepository cRepo;
	
	@Override
	public Caregiver fetchById(Integer id) {
		Optional<Caregiver> caregiver = cRepo.findById(id);
		if(caregiver.isPresent()) {
			return caregiver.get();
		}
		log.error("Caregiver does not exist.Check the id");
		throw new CaregiverNotFoundException("Caregiver does not exist.Please check the id.");
				
	} 
	
	
	@Override
	public List<Caregiver> fetchByFirstname(String firstname) {
		if(!cRepo.findByFirstname(firstname).isEmpty())
		{
			return cRepo.findByFirstname(firstname);
		}
		log.error("Caregiver does not exist.Check the first name");
		throw new CaregiverNotFoundException("Caregiver does not exist.Please check the firstname.");
	} 
	
	
	@Override
	public List<Caregiver> fetchByLastname(String lastname) {
		if(!cRepo.findByLastname(lastname).isEmpty())
		{
			return cRepo.findByLastname(lastname);
		}
		log.error("Caregiver does not exist.Check the last name");
		throw new CaregiverNotFoundException("Caregiver does not exist.Please check the lastname.");
		
	}
	
	@Override
	public List<Caregiver> fetchByEmailid(String emailid) {
		if(!cRepo.findByEmailid(emailid).isEmpty())
		{
			return cRepo.findByEmailid(emailid);
		}
		log.error("Caregiver does not exist.Check the email id");
		throw new CaregiverNotFoundException("Caregiver does not exist.Please check the email id.");
		
	}
	
	 public CaregiverDTO getCaregiver(Integer caregiverid) throws Exception {
			
			
			Optional<Caregiver> caregiverO=cRepo.findById(caregiverid);
			
			if(caregiverO.isPresent()) {
				
				Caregiver caregiver=caregiverO.get();
				
				CaregiverDTO caregiverDTO= convertToDto(caregiver);
				return caregiverDTO;
				
			}else {
				
				throw new Exception("Caregiver with ID "+caregiverid+" Not found");
			}
			
		}
	 public List<Caregiver> getAllCaregiver() throws Exception {
			
			
			
			
			return cRepo.findAll();
			
		}
	   
	    
	    
	    static CaregiverDTO convertToDto(Caregiver caregiver) {
			CaregiverDTO caregiverDTO=new CaregiverDTO();
			caregiverDTO.setCaregiverid(caregiver.getCaregiverid());
			caregiverDTO.setFirstname(caregiver.getFirstname());
			caregiverDTO.setLastname(caregiver.getLastname());
			caregiverDTO.setEmailid(caregiver.getEmailid());
			return caregiverDTO;
		}
	    
				
	
	
	
				
	
	
				
	

}
