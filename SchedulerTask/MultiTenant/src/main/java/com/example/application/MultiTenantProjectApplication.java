package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.application.*")
public class MultiTenantProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantProjectApplication.class, args);
	}

}
