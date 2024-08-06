package com.example.Fingeso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Fingeso.Repository")
@EntityScan(basePackages = "com.example.Fingeso.Entity")
public class FingesoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FingesoApplication.class, args);
	}

}
