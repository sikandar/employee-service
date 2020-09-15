package com.takeaway.employee.service.impl;

import com.takeaway.employee.model.Department;
import com.takeaway.employee.model.Employee;
import com.takeaway.employee.repository.EmployeeRepository;
import com.takeaway.employee.rest.request.EmployeeRequest;
import com.takeaway.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;


    @Override
    public Employee create(EmployeeRequest request) {
        return repository.save(new Employee(request.getEmail(), request.getFullName(), request.getBirthday(), new Department(request.getDepartmentId())));
    }

    @Override
    public Employee update(UUID id, EmployeeRequest request) {
        return repository.save(new Employee(id, request.getEmail(), request.getFullName(), request.getBirthday(), new Department(request.getDepartmentId())));
    }

    @Override
    public Employee findById(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
