package com.demo.rest.service;

import java.util.List;

import com.demo.rest.model.Employee;

public interface EmpService {
	public void create(Employee e);
	public List<Employee> getAllEmp();
	public Employee getEmp(int id);
	public void updateEmp(Employee e);
	public void deleteEmp(int id);
	public void deleteAllEmp();
}
