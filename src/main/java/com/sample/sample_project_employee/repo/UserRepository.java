package com.sample.sample_project_employee.repo;

import com.sample.sample_project_employee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
