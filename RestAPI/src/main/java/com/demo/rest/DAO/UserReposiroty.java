package com.demo.rest.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.model.Users;

public interface UserReposiroty extends JpaRepository<Users, Integer> {
	Optional<Users> findByUsername(String user_name);
	
}
