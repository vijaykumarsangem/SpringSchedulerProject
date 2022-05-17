package com.codingworld.multitenant.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.codingworld.multitenant.feign.EmployeeFeign;
import com.codingworld.multitenant.model.Employee;

@Component
public class Scheduler {

	@Autowired
	EmployeeFeign empFeign;

	@Scheduled(fixedDelay = 600000)
	public void transferData() {

		List<Employee> empList = empFeign.getAll("tenant1");
		if (empList != null && empList.size() > 0) {

			empList.stream().forEach(city -> {
				empFeign.save(city, "tenant2");
			});
		}

	}
}
