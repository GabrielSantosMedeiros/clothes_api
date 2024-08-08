package com.example.clothes_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ClothesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesApiApplication.class, args);
	}

}
