package com.example.projects.studentboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.projects.studentboot.jpa.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByRole(String role);
}
