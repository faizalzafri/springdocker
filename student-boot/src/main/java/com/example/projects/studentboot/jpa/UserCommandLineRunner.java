package com.example.projects.studentboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.projects.studentboot.model.Course;
import com.example.projects.studentboot.model.Student;
import com.example.projects.studentboot.repository.CourseRepository;
import com.example.projects.studentboot.repository.StudentRepository;
import com.example.projects.studentboot.repository.UserRepository;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	/*@Autowired
	private UserRepository repository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;*/

	@Override
	public void run(String... args) throws Exception {/*

		studentRepository.save(new Student("Ranga Karanam", "Hiker, Programmer and Architect", "Spring,Spring Boot"));
		studentRepository.save(new Student("Satish T", "Hiker, Programmer and Architect", "Spring Boot,Maven"));

		courseRepository
				.save(new Course("Spring", "10 Steps", "Learn Maven,Import Project,First Example,Second Example"));
		courseRepository.save(
				new Course("Spring MVC", "10 Examples", "Learn Maven,Import Project,First Example,Second Example"));
		courseRepository.save(new Course("Spring Boot", "6K Students",
				"Learn Maven,Learn Spring,Learn Spring MVC,First Example,Second Example"));
		courseRepository.save(new Course("Maven", "Most popular maven course on internet!",
				"Pom.xml,Build Life Cycle,Parent POM,Importing into Eclipse"));

		repository.save(new User("Ranga", "Admin"));
		repository.save(new User("Ravi", "User"));
		repository.save(new User("Satish", "Admin"));
		repository.save(new User("Raghu", "User"));

		for (User user : repository.findAll()) {
			log.info(user.toString());
		}

		log.info("Admin users are.....");
		log.info("____________________");
		for (User user : repository.findByRole("Admin")) {
			log.info(user.toString());
		}

	*/}

}
