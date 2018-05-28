package com.demo.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String encodePassword(String rawPass, Object salt) {
				// TODO Auto-generated method stub
				return rawPass.toString();
			}
		};
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
			.antMatchers("/emp/add","/emp/deleteall","/emp/delete/*","/emp/upadte").hasRole("Admin")
			.antMatchers("/emp/get").hasRole("User")
			.and().csrf().disable().headers().frameOptions().deny();*/
		http.authorizeRequests()
		.antMatchers("/emp/add","/emp/deleteall","/emp/delete/*","/emp/upadte").permitAll()
		.antMatchers("/emp/get").permitAll()
		.and().csrf().disable().headers().frameOptions().deny();
	}
}
