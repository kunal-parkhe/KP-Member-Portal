package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


import com.example.exception.MailAlreadyExistException;
import com.example.exception.ValidCredentialException;
import com.example.model.AuthenticateRequest;
import com.example.model.AuthenticateResponse;
import com.example.model.Caregiver;
import com.example.model.Member;
import com.example.model.MemberDTO;
import com.example.security.ApplicationSecurity;
import com.example.service.MailService;
import com.example.service.MemberService;
import com.example.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController {

	@Autowired 
	AuthenticationManager authManager;
	
    @Autowired 
    JwtUtil jwtUtil;
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private ApplicationSecurity appSecurity;
	
	@Autowired
	private MailService mailService;
	
	
	@PostMapping("/register")
	public Member registerMember(@Valid @RequestBody Member member) throws Exception {
		if(member.getEmailid() != null && !"".equals(member.getEmailid())) {
			Optional<Member> memberObj = service.fetchMemberByEmailid(member.getEmailid());
			if(memberObj.isPresent()) {
				throw new MailAlreadyExistException("user with "+member.getEmailid()+" is already exist.");
			}
		}
		Member memberObj = null;
		memberObj = service.saveMember(member);
		
		log.debug("Member to register " + memberObj);
		String to = member.getEmailid();
        String subject = "Welcome to Kp Member Portal";
        String body = "Dear " + member.getFirstname() +" "+member.getLastname()+ ",\n\nThank you for registering with us.";
        mailService.sendEmail(to, subject, body);
		
		return memberObj;
	}
	
     
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticateRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
             
            Member member = (Member) authentication.getPrincipal();
            log.info("JWT token created successfully!!");
            String accessToken = jwtUtil.generateAccessToken(member);
            AuthenticateResponse response = new AuthenticateResponse(member.getId(),member.getEmailid(), member.getFirstname(), member.getLastname(), member.getAddress(), accessToken,true);
            log.info("Logged in successfully!!"); 
            return ResponseEntity.ok().body(response);
             
        }catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/getMember/{id}")
	public ResponseEntity<MemberDTO> getMember(@RequestHeader("Authorization") String jwt,@PathVariable Integer id) throws Exception {

		log.info("Member search Id " + id);
		
		ResponseEntity<MemberDTO> response= new ResponseEntity<>(service.getMember(id),HttpStatus.ACCEPTED);

		return response;
	} 
    @GetMapping("/getMemberEmailId/{emailid}")
	public ResponseEntity<MemberDTO> getMemberEmailId(@RequestHeader("Authorization") String jwt,@PathVariable String emailid) throws Exception {

		log.info("Member search Id " + emailid);
		
		ResponseEntity<MemberDTO> response= new ResponseEntity<>(service.getMemberEmailId(emailid),HttpStatus.ACCEPTED);

		return response;
	} 
    @GetMapping("/getAllMemberData")
	public ResponseEntity<List<Member>> getAllCaregiver(@RequestHeader(value="Authorization",required = false, defaultValue = "default-value") String jwt) throws Exception {

		
		
		ResponseEntity<List<Member>> response= new ResponseEntity<>(service.getAllMemberData(),HttpStatus.ACCEPTED);
		
		return response;
	}

	    
    @PostMapping("/validate")
    public boolean validateJwt(@RequestHeader("Authorization") String jwt) throws Exception
    {
    	jwt=jwt.substring(7);
    	log.info("Validating JWT");
    	if(jwtUtil.validateAccessToken(jwt))
    	{
    		return true;
    	}
    	throw new Exception("JWT failed");
    }
    
    
}
	
   
    
    
	
	
	

