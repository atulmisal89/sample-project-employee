package com.sample.sample_project_employee.controller;

import com.sample.sample_project_employee.dto.EmployeeDto;
import com.sample.sample_project_employee.mapper.EmployeeMapper;
import com.sample.sample_project_employee.model.EmployeeModel;
import com.sample.sample_project_employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto)
    {
        EmployeeModel employeeModel = employeeMapper.toEmployeeModel(employeeDto);
        EmployeeModel savedEmployeeModel = employeeService.createEmployee(employeeModel);
        EmployeeDto savedEmployee = employeeMapper.toEmployeeDto(savedEmployeeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/get-single-employee/{id}")
    public ResponseEntity<EmployeeDto> getSingleEmployee(@PathVariable Long id)
    {
        EmployeeModel savedEmployeeModel = employeeService.fetchSingleEmployee(id);
        EmployeeDto fetchEmployee = employeeMapper.toEmployeeDto(savedEmployeeModel);

        return ResponseEntity.ok(fetchEmployee);
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeModel> savedEmployeeModel = employeeService.fetchAllEmployees();
        List<EmployeeDto> fetchEmployee = employeeMapper.toEmployeeDtoList(savedEmployeeModel);

        return ResponseEntity.ok(fetchEmployee);
    }

    @GetMapping("/get-employee-by-mobile-number/{mobileNumber}")
    public ResponseEntity<EmployeeDto> getSingleEmployee(@PathVariable String mobileNumber)
    {
        EmployeeModel savedEmployeeModel = employeeService.fetchEmployeeByMobileNumber(mobileNumber);
        EmployeeDto fetchEmployee = employeeMapper.toEmployeeDto(savedEmployeeModel);

        return ResponseEntity.ok(fetchEmployee);
    }

    @PostMapping("/create-employee-with-address")
    public ResponseEntity<EmployeeDto> saveEmployeeWithAddress(@Valid @RequestBody EmployeeDto employeeDto)
    {
        EmployeeModel employeeModel = employeeMapper.toEmployeeModel(employeeDto);
        EmployeeModel savedEmployeeModel = employeeService.createEmployee(employeeModel);
        EmployeeDto savedEmployee = employeeMapper.toEmployeeDto(savedEmployeeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

}
