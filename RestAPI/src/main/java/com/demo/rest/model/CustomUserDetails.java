package com.demo.rest.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Users implements UserDetails {

	public CustomUserDetails(final Users user) {
		super(user);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("In Authorities");
		List<SimpleGrantedAuthority> collection = getRoles()
		.stream()
		.map(Role -> new SimpleGrantedAuthority(Role.getRole_name()))
		.collect(Collectors.toList());
		return collection;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUser_name();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return (super.getActive() == 1);
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return (super.getActive() == 1);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return (super.getActive() == 1);
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return (super.getActive() == 1);
	}

}
