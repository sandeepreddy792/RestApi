package com.demo.rest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.model.Users;
import java.lang.String;
import java.util.List;

public interface UserReposiroty extends JpaRepository<Users, Integer> {
	List<Users> findByUsername(String user_name);
	
}
