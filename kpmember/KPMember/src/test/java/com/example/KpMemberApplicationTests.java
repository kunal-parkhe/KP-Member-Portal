package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Member;
import com.example.repository.MemberRepo;
import com.example.service.MemberService;

@SpringBootTest
class KpMemberApplicationTests {

	@Autowired
	MemberRepo mRepo;
	
	@Autowired
	MemberService service;
	
	/*@Test
	public void testRegister() {
		Member m= new Member();
		m.setId(1);
		m.setFirstname("Vijay");
		m.setLastname("Surya");
		m.setEmailid("vijay21@gmail.com");
		m.setPassword("abc@VS1221");
		m.setAddress("Chennai");
		mRepo.save(m);
		assertNotNull(mRepo.findByEmailid("vijay21@gmail.com").getEmailid());
	}
	
	@Test
	public void testLogin() {
		Member m= mRepo.findByEmailidAndPassword("vijay21@gmail.com", "abc@VS1221");
		assertEquals(1,m.getId(),
				     "Vijay",m.getFirstname(),
				     "Surya",m.getLastname(),
				     "vijay21@gmail.com",m.getEmailid(),
				     "abc@VS1221",m.getPassword(),
				     "Chennai",m.getAddress());
				     
	@Test
	public void testLogin() {
		String emailid="vijay21@gmail.com";
		String password="abc@VS1221";
		when(mRepo.findByEmailidAndPassword(emailid, password))
				.thenReturn(Stream.of(new Member(1,"Vijay","Surya","vijay21@gmail.com","abc@VS1221","Chennai")).collect(Collectors.toList()));
	assertEquals(1,service.fetchMemberByEmailidAndPassword(emailid, password).size());*/
	

}
