package com.example.servicetests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.model.Caregiver;
import com.example.model.Member;
import com.example.repository.MemberRepo;
import com.example.service.MemberService;

@SpringBootTest(classes = {MemberServiceTests.class})
public class MemberServiceTests {
	
	@Mock
	MemberRepo memberRepo;
	
	@InjectMocks
	MemberService memberService;
	
	@Test
	@Order(1)
    public void testSaveMember() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("Sabee*!234SR");
         
        Member newMember = new Member(2,"Sabee","Ravi","sabee@gmail.com", password,"Chennai");
        Member savedUser = memberRepo.save(newMember);
         
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
	
	
	
	@Test
	@Order(2)
	public void testFetchMemberByEmailid()
	{
		//Optional<Member> member = new Member(1,"Uma","Mahi","uma@gmail.com","Uma*!234UM","Madurai");
		String memberEmailId="uma@gmail.com";
		Mockito.when(memberRepo.findByEmailid(memberEmailId)).thenReturn(Optional.of(new Member(1,"Uma","Mahi",memberEmailId,"Uma*!123UM","Madurai")));
		Optional<Member> member =memberService.fetchMemberByEmailid(memberEmailId);
    	assertEquals("uma@gmail.com",member.equals("uma@gmail.com"));
		//assertEquals(memberEmailId, memberService.fetchMemberByEmailid(memberEmailId));
		
		
	}
	
	

}
