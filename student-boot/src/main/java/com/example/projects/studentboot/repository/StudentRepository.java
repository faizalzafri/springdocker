package com.example.projects.studentboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.studentboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByName(String name);
}
