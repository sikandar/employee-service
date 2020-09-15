package com.takeaway.employee.repository;

import com.takeaway.employee.model.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, UUID> {

}
