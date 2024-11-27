package com.qsp.restaurant_management_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.restaurant_management_project.dto.Employee;
import com.qsp.restaurant_management_project.service.EmployeeService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int id) {
		return employeeService.fetchEmployeeById(id);
	}

	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int id) {
		return employeeService.deleteEmployee(id);
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int oldId,
			@RequestBody Employee newEmployee) {
		return employeeService.updateEmployee(oldId, newEmployee);
	}

	@GetMapping("/fetchAllEmployees")
	public ResponseEntity<ResponseStructure1<Employee>> fetchAllEmployees() {
		return employeeService.fetchAllEmployees();
	}
}
