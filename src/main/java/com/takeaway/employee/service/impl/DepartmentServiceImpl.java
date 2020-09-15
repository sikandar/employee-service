package com.takeaway.employee.service.impl;

import com.takeaway.employee.model.Department;
import com.takeaway.employee.repository.DepartmentRepository;
import com.takeaway.employee.rest.request.DepartmentRequest;
import com.takeaway.employee.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public Department create(DepartmentRequest request) {
        return repository.save(new Department(request.getName()));
    }

    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        repository.findAll().forEach(item -> list.add(item));
        return list;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
