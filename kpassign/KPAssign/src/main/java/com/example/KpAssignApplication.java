package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Caregiver API",version = "2.0",description = "Assign Caregiver"))
@Slf4j
public class KpAssignApplication {

	public static void main(String[] args) {
		log.debug("Start");
		SpringApplication.run(KpAssignApplication.class, args);
	}

}
