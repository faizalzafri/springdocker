package com.example.projects.studentboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.example.projects.studentboot.repository")
@SpringBootApplication
public class StudentBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentBootApplication.class, args);
	}
}
