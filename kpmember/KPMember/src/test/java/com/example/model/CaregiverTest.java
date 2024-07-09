package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaregiverTest {
	Caregiver caregiver = new Caregiver();
	
	@Test
	public void testCaregiverId() {
		caregiver.setCaregiverid(1);
		assertEquals(1,caregiver.getCaregiverid());
	}
	
	@Test
	public void testCaregiverFirstname() {
		caregiver.setFirstname("Ammu");;
		assertEquals("Ammu",caregiver.getFirstname());
	}
	
	@Test
	public void testCaregiverLastname() {
		caregiver.setLastname("Gayathri");
		assertEquals("Gayathri",caregiver.getLastname());
	}
	
	@Test
	public void testCaregiverEmailid() {
		caregiver.setEmailid("ammu@gmail.com");;
		assertEquals("ammu@gmail.com",caregiver.getEmailid());
	}

}
