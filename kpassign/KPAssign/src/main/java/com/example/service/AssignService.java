package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.MemberNotFoundException;
import com.example.feign.MemberFeign;
import com.example.model.AssignCaregiver;
import com.example.model.CaregiverDTO;
import com.example.model.CaregiverData;
import com.example.model.Member;
import com.example.repository.AssignRepo;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class AssignService {
	@Autowired
	AssignRepo repo;
	
	@Autowired
	MemberFeign memberFeign;
	//
	//private static int caregiverDataCount = 0;
     public boolean assignCareGiver(String jwt,Integer memberId, Integer CareGiverId) throws Exception {
    	 
		if(memberId==null || CareGiverId==null) {
			throw new Exception("Id should not be null");
		}
		
		
		if(repo.findBycareGiverId(CareGiverId)!= null) {
			throw new Exception("CareGiver with Id is already assigned, Try others");
		}
		
		//if (caregiverDataCount >= 2) {
	        //Return null or throw an exception indicating that data can't be retrieved more than two times
	       // throw new Exception("Data can only be retrieved a maximum of two times.");
	    //}
		List<AssignCaregiver> assignedCaregivers = repo.findAllByMemberId(memberId);

        if (assignedCaregivers.size() >= 2) {
            throw new Exception("You can only assign up to two caregivers. Delete an assigned caregiver to reassign.");
        }
		CaregiverDTO caregiver;
		Member member;
		
		try {
			caregiver=memberFeign.getCaregiver(jwt, CareGiverId).getBody();
			log.info("Caregiver found");
			member=memberFeign.getMember(jwt, memberId).getBody();
			log.info("Member found");
		} catch (Exception exception) {
			throw new MemberNotFoundException("Member or Caregiver Not Found.Check the Id");
			
		}
		
		
		 AssignCaregiver careGiver=new AssignCaregiver();
		careGiver.setMemberId(memberId);
		careGiver.setCareGiverId(CareGiverId);
		careGiver.setFirstname(caregiver.getFirstname());
 		careGiver.setLastname(caregiver.getLastname());
 		careGiver.setEmailid(caregiver.getEmailid());
		
		log.debug(careGiver.toString());
		repo.save(careGiver);
			
			
		//caregiverDataCount++;
		return true;
	} 
     
     public CaregiverData getCaregiver(String jwt, Integer memberId, Integer careGiverIds) throws Exception{
 		// TODO Auto-generated method stub
 		if(memberId==null || careGiverIds==null) {
 			throw new Exception("Id should not be null");
 		}
 		
 		
 		//if (caregiverDataCounts >= 2) {
 	       // // Return null or throw an exception indicating that data can't be retrieved more than two times
 	       // throw new Exception("Data can only be retrieved a maximum of two times.");
 	    //}
 	  
 		//caregiverdata =caregiverRespository.findByCaregiverid(careGiverIds);
 		CaregiverDTO caregiver;
 		Member member;
 		
 		try {
 			caregiver=memberFeign.getCaregiver(jwt, careGiverIds).getBody();
 			log.info("Caregiver found");
 			member=memberFeign.getMember(jwt, memberId).getBody();
 			log.info("Member found");
 		} catch (Exception exception) {
 			throw new MemberNotFoundException("Member or Caregiver Not Found.Check the Id");
 			
 		}
 		
 		
 		 CaregiverData careGiver=new CaregiverData();
 		 
 		careGiver.setMemberId(memberId);
 		careGiver.setCareGiverId(careGiverIds);
 		careGiver.setFirstname(caregiver.getFirstname());
 		careGiver.setLastname(caregiver.getLastname());
 		careGiver.setEmailid(caregiver.getEmailid());
 		log.debug(careGiver.toString());
 		
 	
 		//caregiverDataCounts++;	
 		
 		return careGiver;
 		
 	}

	public boolean deleteCaregiver(String jwt, Integer memberId, Integer careGiverId) throws Exception {
		// TODO Auto-generated method stub
		if(memberId==null || careGiverId==null) {
 			throw new Exception("Id should not be null");
 		}
		
 		
// 		try {
// 			repo.deleteByMemberIdAndCaregiverId(memberId,careGiverId);
// 			
// 		}catch(Exception exception){
// 			throw new MemberNotFoundException("Member or Caregiver Not Found.Check the Id");
// 			
// 		}
		
 		repo.deleteByMemberIdAndCareGiverId(memberId,careGiverId);
		return true;
	}

	public List<AssignCaregiver> fetchCaregivers(Integer MemberId) {
		// TODO Auto-generated method stub
		return repo.findAllByMemberId(MemberId);
	} 
	
      

}
