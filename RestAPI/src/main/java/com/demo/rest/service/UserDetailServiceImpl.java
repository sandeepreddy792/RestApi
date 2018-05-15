package com.demo.rest.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.rest.DAO.UserReposiroty;
import com.demo.rest.model.Roles;
import com.demo.rest.model.Users;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserReposiroty userReposiroty;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = (Users) userReposiroty.findByUsername(username).get(0);
		
		if(user != null) {
			String password = user.getPassword();
			boolean enabled = (user.getActive() == 1);
			boolean accountNonExpired = (user.getActive() == 1);
			boolean credentialsNonExpired = (user.getActive() == 1);
			boolean accountNonLocked = (user.getActive() == 1);
			
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			for(Roles role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
			}
			System.out.println(authorities);
			User userDetails = new User(username, password, enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
			
			return userDetails;
		}
		else {
			throw new UsernameNotFoundException("User Not Found!!!!");
		}
	}

}
