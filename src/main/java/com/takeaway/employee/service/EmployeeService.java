package com.takeaway.employee.service;

import java.time.LocalDate;
import java.util.UUID;

import com.takeaway.employee.model.Employee;
import com.takeaway.employee.rest.request.EmployeeRequest;

public interface EmployeeService {


	void create(EmployeeRequest request);
	void update(UUID id, EmployeeRequest request);
	Employee findById(UUID id);
	void delete(UUID id);

}
