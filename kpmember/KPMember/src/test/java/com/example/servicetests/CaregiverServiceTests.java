package com.example.servicetests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Caregiver;
import com.example.repository.CaregiverRepository;
import com.example.service.CaregiverServiceImpl;

@SpringBootTest(classes = {CaregiverServiceTests.class})
public class CaregiverServiceTests {

	@MockBean
	CaregiverRepository caregiverRepository;
	
	@Autowired
	CaregiverServiceImpl caregiverService;
	
//	    @Test
//		@Order(1)
//		public void testFetchById()
//		{
//						
//	    	when(caregiverRepository.findById(1)).thenReturn(Optional.of(new Caregiver(1,"Uma","Mahi","uma@gmail.com",null)));
//	    	Caregiver caregiver =caregiverService.fetchById(1);
//	    	assertEquals(1,caregiver.getCaregiverid());
// 		} 
		
//		@Test
//		@Order(2)
//		public void testFetchByFirstName()
//		{
//			when(caregiverRepository.findByFirstname("Uma")).thenReturn(Stream.of(new Caregiver(1,"Uma","Mahi","uma@gmail.com",null)).collect(Collectors.toList()));
//			Caregiver caregiver = caregiverService.fetchByFirstname("Uma").get(0);
//			assertEquals("Uma",caregiver.getFirstname());
//		}
//		
//		@Test
//		@Order(3)
//		public void testFetchByLastName()
//		{
//			when(caregiverRepository.findByLastname("Mahi")).thenReturn(Stream.of(new Caregiver(1,"Uma","Mahi","uma@gmail.com",null)).collect(Collectors.toList()));
//			Caregiver caregiver = caregiverService.fetchByLastname("Mahi").get(0);
//			assertEquals("Mahi",caregiver.getLastname());
//		}
//		
//		@Test
//		@Order(4)
//		public void testFetchByEmailid()
//		{
//			when(caregiverRepository.findByEmailid("uma@gmail.com")).thenReturn(Stream.of(new Caregiver(1,"Uma","Mahi","uma@gmail.com",null)).collect(Collectors.toList()));
//			Caregiver caregiver = caregiverService.fetchByEmailid("uma@gmail.com").get(0);
//			assertEquals("uma@gmail.com",caregiver.getEmailid());
//		}
}
