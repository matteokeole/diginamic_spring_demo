package com.diginamic.demo;

import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@Transactional
public class Application {
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}