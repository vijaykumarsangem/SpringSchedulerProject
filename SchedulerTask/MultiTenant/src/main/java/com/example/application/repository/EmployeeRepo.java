package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
