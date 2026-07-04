package com.sample.sample_project_employee.model;

import com.sample.sample_project_employee.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeModel {

    private Long id;
    private Integer age;
    private String name;
    private Double salary;
    private String mobile;
    private List<Address> addresses;
}