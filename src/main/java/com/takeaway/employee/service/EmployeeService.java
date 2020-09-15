package com.takeaway.employee.service;

import java.time.LocalDate;
import java.util.UUID;

import com.takeaway.employee.model.Employee;

public interface EmployeeService {


	Employee create(String email, String fullName, LocalDate birthday, UUID departmentId);
	Employee update(UUID id, String email, String fullName, LocalDate birthday, UUID departmentId);
	Employee findById(UUID id);
	void delete(UUID id);

}
