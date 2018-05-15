package com.demo.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
		.and().withUser("admin").password("admin").roles("USER","ADMIN");*/
		//auth.userDetailsService(userDetailsService);
		AuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		((DaoAuthenticationProvider) authenticationProvider).setUserDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/emp/add","/emp/deleteall","/emp/delete/*","/emp/upadte").hasRole("Admin")
		.antMatchers("/emp/get").hasRole("User").and().csrf().disable().headers().frameOptions().deny();
	}
}
