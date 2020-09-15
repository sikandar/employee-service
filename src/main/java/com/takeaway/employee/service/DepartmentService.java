package com.takeaway.employee.service;

import com.takeaway.employee.model.Department;
import com.takeaway.employee.model.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DepartmentService {

	Department create(String name);
	List<Department> findAll();
	void delete(UUID id);

}
