package com.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PreAuthorize("hasAnyRole('Admin')")
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String add(@RequestBody Employee e) {
		System.out.println("In add method");
		/*System.out.println(e.getEmpno());
		System.out.println(e.getEmpname());
		System.out.println(e.getEmpsal());*/
		empService.create(e);
		return "success";
	}
	
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployee(){
		return empService.getAllEmp();
	}
	
	
	@GetMapping(value = "/get/{EmpId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable(name = "EmpId") int id) {
		return empService.getEmp(id);
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployee(@RequestBody Employee e) {
		empService.updateEmp(e);
		return "success";
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@DeleteMapping(value = "/delete/{EmpId}")
	public String deleteEmployee(@PathVariable(name = "EmpId") int id) {
		empService.deleteEmp(id);
		return "success";
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		empService.deleteAllEmp();
		return "success";
	}
}
