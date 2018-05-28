package com.demo.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.rest.DAO.UserReposiroty;
import com.demo.rest.model.CustomUserDetails;
import com.demo.rest.model.Users;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserReposiroty userReposiroty;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userReposiroty.findByUsername(username);
		System.out.println("User Detail Service");
		user.orElseThrow(()->new UsernameNotFoundException("Username Not Found..!"));
		return user.map(CustomUserDetails::new).get();
		
	}

}
