package com.takeaway.employee.rest.controller;

import com.takeaway.employee.rest.request.DepartmentRequest;
import com.takeaway.employee.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
@Tag(name = "Department")
@Validated
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    @Operation(summary = "Get Departments list")
    public ResponseEntity<?> department() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @Operation(summary = "Create a new Department")
    public ResponseEntity<?> department(@RequestBody @Valid DepartmentRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an Department")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void department(@PathVariable UUID id) {
        service.delete(id);
    }


}
