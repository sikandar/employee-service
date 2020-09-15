package com.takeaway.employee.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.takeaway.employee.model.Employee;
import com.takeaway.employee.rest.request.EmployeeRequest;

public interface EmployeeService {


	Employee findById(UUID id);
	List<Employee> findAll();
	void create(EmployeeRequest request);
	void update(UUID id, EmployeeRequest request);
	void delete(UUID id);

}
