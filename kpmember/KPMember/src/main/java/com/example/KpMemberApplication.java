package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Member API",version = "2.0",description = "Registration/Logout"))
@Slf4j
public class KpMemberApplication {

	public static void main(String[] args) {
		log.debug("Start");
		SpringApplication.run(KpMemberApplication.class, args);
	}

}
