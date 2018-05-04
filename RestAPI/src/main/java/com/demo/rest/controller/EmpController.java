package com.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.model.Employee;
import com.demo.rest.service.EmpService;
import com.demo.rest.service.EmpServiceImpl;

@RestController
@RequestMapping(value = "/emp")
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@Bean
	EmpService empService() {
		return new EmpServiceImpl();
	}
	
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String add(Employee e) {
		//System.out.println("In add method");
		System.out.println(e.getEmpno());
		System.out.println(e.getEmpname());
		System.out.println(e.getEmpsal());
		empService.create(e);
		return "success";
	}
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployee(){
		return empService.getAllEmp();
	}
}
