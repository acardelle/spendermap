package com.cardelle.SpenderMap2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class SpenderMap2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpenderMap2Application.class, args);
	}

}

