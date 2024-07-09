package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {
	
	
	@Query(value = "SELECT m FROM Member m WHERE m.emailid = ?1")
	public Member getMemberByUserName(String username); 
	
	public Optional<Member> findByEmailid(String username);
	
	

}
