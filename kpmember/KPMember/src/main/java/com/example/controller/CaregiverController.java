package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.model.Caregiver;
import com.example.model.CaregiverDTO;
import com.example.model.MemberDTO;
import com.example.repository.CaregiverRepository;
import com.example.service.CaregiverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

public class CaregiverController {
	@Autowired
	private CaregiverService cService;
	
	@Autowired
	private CaregiverRepository cRepo;
	
//	@GetMapping("/search/simple/id/{id}")
//	public Caregiver searchCaregiverById(@PathVariable Integer id) {
//		log.info("Caregiver with the id "+id+" is fetched");
//		return cService.fetchById(id);
//	}
	
	@GetMapping("/search/advance/firstname/{firstname}")
	public List<Caregiver> searchCaregiverByFirstname(@PathVariable String firstname) {
		log.info("Caregiver with the firstname "+firstname+" is fetched");
		return cService.fetchByFirstname(firstname);
	}
	
	@GetMapping("/search/advance/lastname/{lastname}")
	public List<Caregiver> searchCaregiverByLastname(@PathVariable String lastname) {
		log.info("Caregiver with the last name "+lastname+" is fetched");
		return cService.fetchByLastname(lastname);
	}
	
	@GetMapping("/search/advance/email/{emailid}")
	public List<Caregiver> searchCaregiverByEmailid(@PathVariable String emailid) {
		log.info("Caregiver with the email id "+emailid+" is fetched");
		return cService.fetchByEmailid(emailid);
	}
	
	@GetMapping("/getCaregiver/{id}")
	public ResponseEntity<CaregiverDTO> getCaregiver(@RequestHeader("Authorization") String jwt,@PathVariable Integer id) throws Exception {

		log.info("Caregiver search Id " + id);
		
		ResponseEntity<CaregiverDTO> response= new ResponseEntity<>(cService.getCaregiver(id),HttpStatus.ACCEPTED);

		return response;
	}
	@GetMapping("/getAllCaregiver")
	public ResponseEntity<List<Caregiver>> getAllCaregiver(@RequestHeader(value="Authorization",required = false, defaultValue = "default-value") String jwt) throws Exception {

		
		
		ResponseEntity<List<Caregiver>> response= new ResponseEntity<>(cService.getAllCaregiver(),HttpStatus.ACCEPTED);
		
		return response;
	}


    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}
