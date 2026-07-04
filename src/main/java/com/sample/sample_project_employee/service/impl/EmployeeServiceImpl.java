package com.sample.sample_project_employee.service.impl;

import com.sample.sample_project_employee.entity.Employee;
import com.sample.sample_project_employee.exception.ResourceNotFoundException;
import com.sample.sample_project_employee.mapper.EmployeeMapper;
import com.sample.sample_project_employee.model.EmployeeModel;
import com.sample.sample_project_employee.repo.EmployeeRepo;
import com.sample.sample_project_employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {

        Employee employee = employeeMapper.toEntity(employeeModel);

        Employee savedEmployee = employeeRepo.save(employee);

        return employeeMapper.toEmployeeModel(savedEmployee);
    }

    @Override
    public EmployeeModel fetchSingleEmployee(Long id) {

        Employee fetchedEmployee=employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", id));

            return employeeMapper.toEmployeeModel(fetchedEmployee);
        }

    @Override
    public List<EmployeeModel> fetchAllEmployees() {

        List<Employee> employees=employeeRepo.findAll();

        return employeeMapper.toEmployeeModelList(employees);
    }

    @Override
    public EmployeeModel fetchEmployeeByMobileNumber(String mobileNumber) {

        Employee fetchedEmployee=employeeRepo.findByMobile(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("Employee", mobileNumber));

        return employeeMapper.toEmployeeModel(fetchedEmployee);
    }
}
