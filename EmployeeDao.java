package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Employee;
import com.qsp.restaurant_management_project.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isEmpty()) {
			return null;
		} else {
			return employee.get();
		}
	}

	public Employee deleteEmployee(int id) {
		Employee employee = fetchEmployeeById(id);
		employeeRepo.delete(employee);
		return employee;
	}

	public Employee updateEmployee(int oldId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldId);
		return employeeRepo.save(newEmployee);
	}

	public List<Employee> fetchAllEmployees() {
		return employeeRepo.findAll();
	}
}
