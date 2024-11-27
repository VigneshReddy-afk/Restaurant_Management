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
import com.qsp.restaurant_management_project.dto.Customer;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.service.CustomerService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int id) {
		return customerService.fetchCustomerById(id);
	}

	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int id) {
		return customerService.deleteCustomer(id);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestParam int oldId,
			@RequestBody Customer newCustomer) {
		return customerService.updateCustomer(oldId, newCustomer);
	}

	@GetMapping("/fetchAllCustomers")
	public ResponseEntity<ResponseStructure1<Customer>> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
	}

	@PutMapping("/addExistingFoodOrderToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(
			@RequestParam int foodOrderId, @RequestParam int customerId) {
		return customerService.addExistingFoodOrderToExistingCustomer(foodOrderId, customerId);
	}

	@PutMapping("/addNewFoodOrderToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(@RequestParam int customerId,
			@RequestBody FoodOrder foodOrder) {
		return customerService.addNewFoodOrderToExistingCustomer(customerId, foodOrder);
	}
}
