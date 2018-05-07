package com.demo.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.demo.rest.service,com.demo.rest.controller,com.demo.rest.config")
@EntityScan(basePackages = "com.demo.rest.model")
@EnableJpaRepositories(basePackages = "com.demo.rest.DAO")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
}
