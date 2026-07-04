package com.sample.sample_project_employee.service;

import com.sample.sample_project_employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    EmployeeModel createEmployee(EmployeeModel employeeModel);

    EmployeeModel fetchSingleEmployee(Long id);

    List<EmployeeModel> fetchAllEmployees();

    EmployeeModel fetchEmployeeByMobileNumber(String mobileNumber);
}
