package com.periferia.hackaton.mutantes.adn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "com.periferia.hackaton.mutantes.adn.infraestructure.database.models")
public class AdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdnApplication.class, args);
	}

}
