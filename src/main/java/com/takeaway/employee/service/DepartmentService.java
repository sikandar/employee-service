package com.takeaway.employee.service;

import com.takeaway.employee.model.Department;
import com.takeaway.employee.rest.request.DepartmentRequest;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

	Department create(DepartmentRequest request);
	List<Department> findAll();
	void delete(UUID id);

}
