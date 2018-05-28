package com.demo.rest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@Column(name = "USER_ID")
	private int user_id;
	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "FIRST_NAME")
	private String first_name;
	@Column(name = "LAST_NAME")
	private String last_name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ACTIVE")
	private int active;
	@ManyToMany(targetEntity = Roles.class,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinTable(name  = "USER_ROLES", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Roles> roles;
	
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return username;
	}
	public void setUser_name(String user_name) {
		this.username = user_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	public Users() {}
	
	public Users(Users users) {
		super();
		this.user_id = users.getUser_id();
		this.username = users.getUser_name();
		this.first_name = users.getFirst_name();
		this.last_name = users.getLast_name();
		this.email = users.getEmail();
		this.password = users.getPassword();
		this.active = users.getActive();
		this.roles = users.getRoles();
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + username + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", password=" + password + ", active=" + active + "]";
	}
	
	
}
