package com.example.projects.studentboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.projects.studentboot.model.Course;
import com.example.projects.studentboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{studentName}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentName) {
		return studentService.retrieveCourses(studentName);
	}

	@PostMapping("/students/{studentName}/courses")
	public ResponseEntity<Void> registerStudentForCourse(@PathVariable String studentName,
			@RequestBody Course newCourse) {

		Course course = studentService.addCourse(studentName, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/students/{studentName}/courses/{courseName}")
	public Course retrieveDetailsForCourse(@PathVariable String studentName, @PathVariable String courseName) {
		return studentService.retrieveCourse(studentName, courseName);
	}

}
