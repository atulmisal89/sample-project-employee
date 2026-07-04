package com.sample.sample_project_employee.dto;

import com.sample.sample_project_employee.entity.Address;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EmployeeDto(

        Long id,

        @NotNull(message = "Age is required")
        @Min(value = 18, message = "Age must be at least 18")
        Integer age,

        @NotBlank(message = "Name should not be null, blank, or empty")
        String name,

        @Min(value = 15000, message = "Salary must be at least 15000")
        Double salary,

        @NotBlank(message = "Mobile number should not be null, blank, or empty")
        String mobile,

        List<Address> addresses

) {}