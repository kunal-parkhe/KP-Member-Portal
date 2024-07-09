package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.AssignCaregiver;
import com.example.model.Member;

@Repository
public interface AssignRepo extends JpaRepository<AssignCaregiver ,Integer>{
	
	AssignCaregiver findBycareGiverId(Integer id);
	
	@Transactional
	void deleteByMemberIdAndCareGiverId(Integer memberId, Integer careGiverId);

	List<AssignCaregiver> findAllByMemberId(Integer memberId);
	
	
	/* @Query(value="select count(*) from Assign_Caregiver where member_id = (select id from Member)",nativeQuery = true)
	public Integer countMember(); */


	

}
