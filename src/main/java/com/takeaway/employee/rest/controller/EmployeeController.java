package com.takeaway.employee.rest.controller;

import com.takeaway.employee.rest.request.EmployeeRequest;
import com.takeaway.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
@Tag(name = "Employee")
@Validated
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    @Operation(summary = "Get All employees")
    public ResponseEntity<?> employees() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping(value = "/{id}")
    @Operation(summary = "Get employee information")
    public ResponseEntity<?> employees(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new Employee")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void employee(@RequestBody @Valid EmployeeRequest request) {
        service.create(request);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update an Employee")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void employee(@PathVariable UUID id, @RequestBody @Valid EmployeeRequest request) {
        service.update(id, request);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an Employee")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void employee(@PathVariable UUID id) {
        service.delete(id);
    }


}
