package com.takeaway.employee.rest.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DepartmentRequest {
    @NotEmpty
    private String name;
}
