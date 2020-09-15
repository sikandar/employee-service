package com.takeaway.employee.rest.controller;

import com.takeaway.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
@Tag(name = "Employee")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get employee information")
    public ResponseEntity<?> accounts(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/")
    @Operation(summary = "Create a new Employee")
    public ResponseEntity<?> employee(@RequestParam String email,
                                      @RequestParam String fullName, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday, @RequestParam UUID departmentId) {
        return ResponseEntity.ok(service.create(email, fullName, birthday, departmentId));
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update an Employee")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void employee(@PathVariable UUID id, @RequestParam String email, @RequestParam String fullName, @RequestParam LocalDate birthday, @RequestParam UUID departmentId) {
        service.update(id, email, fullName, birthday, departmentId);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an Employee")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void employee(@PathVariable UUID id) {
        service.delete(id);
    }


}
