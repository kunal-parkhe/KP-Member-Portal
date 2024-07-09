package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {
    Member member = new Member();
    
    @Test
    public void testId() {
    	member.setId(1);
    	assertEquals(1,member.getId());
    }
    
    @Test
    public void testFirstname() {
    	member.setFirstname("Ammu");
    	assertEquals("Ammu",member.getFirstname());
    }
    
    @Test
    public void testLastname() {
    	member.setLastname("Gayathri");;
    	assertEquals("Gayathri",member.getLastname());
    }
    
    @Test
    public void testEmailid() {
    	member.setEmailid("ammu@gmail.com");;
    	assertEquals("ammu@gmail.com",member.getEmailid());
    }
    
    @Test
    public void testAddress() {
    	member.setAddress("Chennai");;
    	assertEquals("Chennai",member.getAddress());
    }
    
}

