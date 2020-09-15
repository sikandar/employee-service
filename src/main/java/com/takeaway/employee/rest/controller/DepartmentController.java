package com.takeaway.employee.rest.controller;

import com.takeaway.employee.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
@Tag(name = "Department")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping(value = "/")
    @Operation(summary = "Get Departments list")
    public ResponseEntity<?> department() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "/")
    @Operation(summary = "Create a new Department")
    public ResponseEntity<?> employee(@RequestParam String name) {
        return ResponseEntity.ok(service.create(name));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an Department")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void employee(@PathVariable UUID id) {
        service.delete(id);
    }


}
