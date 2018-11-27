package com.example.projects.studentboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.projects.studentboot.jpa.User;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRestRepository extends
		PagingAndSortingRepository<User, Long> {
	List<User> findByRole(@Param("role") String role);
}
