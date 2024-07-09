package com.example.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.model.CaregiverDTO;
import com.example.model.Member;





@FeignClient(name = "${MemberFeign.name}",url = "${MemberFeign.url}")
public interface MemberFeign {
	@PostMapping("/register")
	public Member registerMember(@Valid @RequestBody Member member);
	
	@PostMapping("/validate")
	public boolean validateJwt(@RequestHeader("Authorization") String jwt);
	
	/*@PostMapping("/validate")
	public ResponseEntity<Boolean> validateJwt(@RequestHeader("Authorization") String jwt);*/
	
	@GetMapping("/getMember/{id}")
	public ResponseEntity<Member> getMember(@RequestHeader("Authorization") String jwt,@PathVariable Integer id);
	
	@GetMapping("/getCaregiver/{id}")
	public ResponseEntity<CaregiverDTO> getCaregiver(@RequestHeader("Authorization") String jwt,@PathVariable Integer id);
	
	@GetMapping("/getMemberEmailId/{emailid}")
	public ResponseEntity<Member> getMemberEmailId(@RequestHeader("Authorization") String jwt,@PathVariable String Emailid);
		

}
