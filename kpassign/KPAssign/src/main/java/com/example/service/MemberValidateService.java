package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feign.MemberFeign;

@Service
public class MemberValidateService {
	
	@Autowired
	MemberFeign memFeign;
	
	public boolean validateJwt(String jwt) {
		return memFeign.validateJwt(jwt);
	}

}
