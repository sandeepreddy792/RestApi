package com.demo.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.rest.DAO.EmpRepository;
import com.demo.rest.model.Employee;

public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public void create(Employee e) {
		empRepository.saveAndFlush(e);
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepository.findAll();
	}

	@Override
	public Employee getEmp(int id) {
		return empRepository.findOne(id);
	}

	@Override
	public void updateEmp(Employee e) {
		Employee e1 = empRepository.getOne(e.getEmpno());
		e1.setEmpname(e.getEmpname());
		e1.setEmpsal(e.getEmpsal());
		empRepository.saveAndFlush(e1);
	}

	@Override
	public void deleteEmp(int id) {
		empRepository.delete(id);
	}

	@Override
	public void deleteAllEmp() {
		empRepository.deleteAll();
	}

}
