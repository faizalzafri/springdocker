package com.example.projects.studentboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.studentboot.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findByName(String name);
}
