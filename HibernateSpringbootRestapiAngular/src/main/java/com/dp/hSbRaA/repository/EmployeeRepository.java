package com.dp.hSbRaA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.hSbRaA.model.Employee;

//interface

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByName(String name);
}
