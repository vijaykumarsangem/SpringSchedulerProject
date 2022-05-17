package com.example.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.model.Employee;
import com.example.application.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo emprepo;

	public void saveEmp(Employee emp) {
		emprepo.save(emp);
	}

	public List<Employee> getAll() {
		return emprepo.findAll();
	}

	public Employee getEmployeeByid(int empid) {
		return emprepo.findById(empid).get();
	}
}
