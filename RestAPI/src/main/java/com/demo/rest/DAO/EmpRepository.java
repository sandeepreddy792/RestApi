package com.demo.rest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
