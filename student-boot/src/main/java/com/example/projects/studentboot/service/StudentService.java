package com.example.projects.studentboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.projects.studentboot.model.Course;
import com.example.projects.studentboot.model.Student;
import com.example.projects.studentboot.repository.CourseRepository;
import com.example.projects.studentboot.repository.StudentRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class StudentService {

	private static List<Student> students = new ArrayList<>();

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	static {
		// Initialize Data
		/*
		 * Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
		 * .asList("Learn Maven", "Import Project", "First Example", "Second Example"));
		 * Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
		 * Arrays.asList("Learn Maven", "Import Project", "First Example",
		 * "Second Example")); Course course3 = new Course("Course3", "Spring Boot",
		 * "6K Students", Arrays.asList("Learn Maven", "Learn Spring",
		 * "Learn Spring MVC", "First Example", "Second Example")); Course course4 = new
		 * Course("Course4", "Maven", "Most popular maven course on internet!",
		 * Arrays.asList( "Pom.xml", "Build Life Cycle", "Parent POM",
		 * "Importing into Eclipse"));
		 * 
		 * Student ranga = new Student("Student1", "Ranga Karanam",
		 * "Hiker, Programmer and Architect", new ArrayList<>(Arrays .asList(course1,
		 * course2, course3, course4)));
		 * 
		 * Student satish = new Student("Student2", "Satish T",
		 * "Hiker, Programmer and Architect", new ArrayList<>(Arrays .asList(course1,
		 * course2, course3, course4)));
		 * 
		 * students.add(ranga); students.add(satish);
		 */ }

	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	public Student retrieveStudent(String name) {
		return studentRepository.findByName(name);
	}

	public List<Course> retrieveCourses(String name) {

		Student student = retrieveStudent(name);	
		List<String> t = Arrays.asList(student.getCourses().split(","));
		return t.stream().map(coursename -> courseRepository.findByName(coursename)).collect(Collectors.toList());
	}

	public Course retrieveCourse(String name, String courseName) {
		Student student = retrieveStudent(name);

		if (student == null) {
			return null;
		}

		for (String course : student.getCourses().split(",")) {
			if (course.equals(courseName)) {
				return courseRepository.findByName(courseName);
			}
		}

		return null;
	}

	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);
		if (student == null) {
			return null;
		}
		student.setCourses(student.getCourses().concat("," + course.getName()));
		studentRepository.save(student);
		return courseRepository.save(course);
	}
}