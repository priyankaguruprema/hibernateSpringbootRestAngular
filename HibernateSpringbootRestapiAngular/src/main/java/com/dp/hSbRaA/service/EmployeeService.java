package com.dp.hSbRaA.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.dp.hSbRaA.model.Employee;
import com.dp.hSbRaA.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	
	
	//constructor
public EmployeeService(EmployeeRepository employeeRepository){
	this.employeeRepository=employeeRepository;
}



//SAVE
public Employee save(Employee employee) {
	//if id is null or already exits
	if (employee.getId() != null && employeeRepository.exists(employee.getId())) {
		throw new EntityExistsException("There is already existing entity with such ID in the database.");
	}

	return employeeRepository.save(employee);
}


//UPATE
public Employee update(Employee employee) {
	//if id is null or doesnt exits
	if (employee.getId() != null && !employeeRepository.exists(employee.getId())) {
		throw new EntityNotFoundException("There is no entity with such ID in the database.");
	}

	return employeeRepository.save(employee);
}

//FIND ALL
public List<Employee> findAll() {
	return employeeRepository.findAll();
}

//FIND ONE
public Employee findOne(Integer id) {
	return employeeRepository.findOne(id);
}


//DELETE
public void delete(Integer id) {
	employeeRepository.delete(id);
}




}
