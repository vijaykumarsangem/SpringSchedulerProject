package com.example.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.model.Employee;
import com.example.application.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empserv;

	@PostMapping("/add")
	public String saveEmployee(@RequestBody Employee emp) {
		empserv.saveEmp(emp);
		return "saved";
	}

	@GetMapping("/getAll")
	public List<Employee> getEmployee() {
		return empserv.getAll();
	}

	@GetMapping("/get/{empid}")
	public Employee getEmployee(@PathVariable int empid) {
		return empserv.getEmployeeByid(empid);
	}
}
