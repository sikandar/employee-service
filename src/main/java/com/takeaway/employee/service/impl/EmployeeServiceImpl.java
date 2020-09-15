package com.takeaway.employee.service.impl;

import com.takeaway.employee.model.Department;
import com.takeaway.employee.model.Employee;
import com.takeaway.employee.repository.EmployeeRepository;
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
    public Employee create(String email, String fullName, LocalDate birthday, UUID departmentId) {
        return repository.save(new Employee(email, fullName, birthday, new Department(departmentId)));
    }

    @Override
    public Employee update(UUID id, String email, String fullName, LocalDate birthday, UUID departmentId) {
        return repository.save(new Employee(id, email, fullName, birthday, new Department(departmentId)));
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
