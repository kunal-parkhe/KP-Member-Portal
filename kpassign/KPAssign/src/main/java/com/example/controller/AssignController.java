package com.example.controller;

//import java.net.http.HttpHeaders;
import org.springframework.http.HttpHeaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.feign.MemberFeign;
import com.example.model.AssignCaregiver;
import com.example.model.CaregiverData;
import com.example.model.Member;
import com.example.service.AssignService;
import com.example.service.MemberValidateService;
import com.example.service.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AssignController {
	@Autowired
	AssignService service;
	
	@Autowired
	MemberValidateService memService;
	
	@Autowired
	MemberFeign memberFeign;
	@Autowired
	private MailService mailService;
	
	Member member;
	
	
	@PostMapping("/assign/{memberId}/{careGiverId}")
	public ResponseEntity<Boolean> Registration(@RequestHeader("Authorization") String jwt, @PathVariable Integer memberId,@PathVariable Integer careGiverId) throws Exception{
		
		ResponseEntity<Boolean> entity=new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		log.debug("Member Id="+memberId+" caregiver id = "+careGiverId);
		log.info("started");
		service.assignCareGiver(jwt, memberId, careGiverId);
		if(jwt.length() >0 && memService.validateJwt(jwt)) {
			entity = new ResponseEntity<>(true,HttpStatus.ACCEPTED);
			
			String to = "kunal.21810049@viit.ac.in";
	        String subject = "Welcome to Kp Member Portal";
	        String body = ",\n\nCaregiver assign succesfully";
	        mailService.sendEmail(to, subject, body);
			//HttpHeaders headers = entity.getHeaders();
		    //headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
		} else {
			throw new Exception("JWT Token is not valid");
		}

		
        return entity;
        
	}
	
	@GetMapping("/fetch/{memberId}")
	public ResponseEntity<List<AssignCaregiver>> fetchcaregiver(@RequestHeader("Authorization") String jwt, @PathVariable Integer memberId) throws Exception{
		
		ResponseEntity<List<AssignCaregiver>> response= new ResponseEntity<>(service.fetchCaregivers(memberId),HttpStatus.ACCEPTED);
        

		
		 return response;
	}
	
	@GetMapping("/get/{memberId}/{careGiverId}")
	public ResponseEntity<?> showcaregiver(@RequestHeader("Authorization") String jwt, @PathVariable Integer memberId,@PathVariable Integer careGiverId) throws Exception{
		
		 
        
        
		log.debug("Member Id="+memberId+" caregiver id = "+careGiverId);
		
		CaregiverData response=service.getCaregiver(jwt, memberId, careGiverId);

		
		 return ResponseEntity.ok().body(response);
	}
	@PostMapping("/delete/{memberId}/{careGiverId}")
	public boolean deletecaregiver(@RequestHeader("Authorization") String jwt, @PathVariable Integer memberId,@PathVariable Integer careGiverId) throws Exception{
		
		 
        
        
		log.debug("Member Id="+memberId+" caregiver id = "+careGiverId);
		
		service.deleteCaregiver(jwt, memberId, careGiverId);

		
		 return true;
	}
	

}
