package com.takeaway.employee.repository;

import com.takeaway.employee.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, UUID> {


}
