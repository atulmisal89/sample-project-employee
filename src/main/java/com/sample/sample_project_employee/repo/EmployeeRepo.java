package com.sample.sample_project_employee.repo;

import com.sample.sample_project_employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {


    Optional<Employee> findByMobile(String mobileNumber);

}
