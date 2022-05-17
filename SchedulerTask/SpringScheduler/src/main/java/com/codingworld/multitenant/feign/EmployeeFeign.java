
package com.codingworld.multitenant.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.codingworld.multitenant.model.Employee;

@FeignClient(name = "EmployeeScheduler", url = "http://localhost:8080")
public interface EmployeeFeign {

	@GetMapping("/getAll")
	List<Employee> getAll(@RequestHeader(name = "X-TenantID") String XTenantId);

	@PostMapping(value = "/add")
	public String save(@RequestBody Employee city,
			@RequestHeader(name = "X-TenantID") String XTenantId);

}
