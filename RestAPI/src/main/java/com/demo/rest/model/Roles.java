package com.demo.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Roles {
	@Id
	@Column(name = "ROLE_ID")
	private int role_id;
	@Column(name = "ROLE_NAME")
	private String role_name;
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public Roles() {}
	public Roles(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		return "Roles [role_id=" + role_id + ", role_name=" + role_name + "]";
	}
	
	
}
