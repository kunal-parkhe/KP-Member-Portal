package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.exception.CaregiverNotFoundException;
import com.example.model.Caregiver;
import com.example.model.Member;
import com.example.model.MemberDTO;
import com.example.repository.CaregiverRepository;
import com.example.repository.MemberRepo;
import com.example.security.ApplicationSecurity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService  {
	@Autowired
	private MemberRepo memrepo;
	
	@Autowired
	private CaregiverRepository cRepo;
	
	@Autowired
	ApplicationSecurity appSecurity;
	
	public Member saveMember(Member member) {
		log.info("Member registered successfully "+member);
		member.setPassword(appSecurity.passwordEncoder().encode(member.getPassword()));
		return memrepo.save(member);
	}
	
	public Optional<Member> fetchMemberByEmailid(String email) {
		return memrepo.findByEmailid(email);
	}
	
	
    public MemberDTO getMember(Integer id) throws Exception {
		
		
		Optional<Member> memberO=memrepo.findById(id);
		
		if(memberO.isPresent()) {
			
			Member member=memberO.get();
			
			MemberDTO memberDTO= convertToDto(member);
			return memberDTO;
			
		}else {
			
			throw new Exception("Member with ID "+id+" Not found");
		}
		
	}
    public List<Member> getAllMemberData() throws Exception {
		
		
		
		
		return memrepo.findAll();
		
	}
    //email
    public MemberDTO getMemberEmailId(String emailid) throws Exception {
		
		
		Optional<Member> memberO=memrepo.findByEmailid(emailid);
		
		if(memberO.isPresent()) {
			
			Member member=memberO.get();
			
			MemberDTO memberDTO= convertToDto(member);
			return memberDTO;
			
		}else {
			
			throw new Exception("Member with ID "+emailid+" Not found");
		}
		
	}
   
    
    
    static MemberDTO convertToDto(Member member) {
		MemberDTO memberDTO=new MemberDTO();
		memberDTO.setId(member.getId());
		memberDTO.setFirstname(member.getFirstname());
		memberDTO.setLastname(member.getLastname());
		memberDTO.setEmailid(member.getEmailid());
		memberDTO.setAddress(member.getAddress());
		return memberDTO;
	}
    
    

	
}
