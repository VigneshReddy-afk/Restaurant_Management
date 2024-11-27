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

import com.qsp.restaurant_management_project.dto.Address;
import com.qsp.restaurant_management_project.dto.Branch;
import com.qsp.restaurant_management_project.dto.Customer;
import com.qsp.restaurant_management_project.dto.Employee;
import com.qsp.restaurant_management_project.dto.Manager;
import com.qsp.restaurant_management_project.dto.Menu;
import com.qsp.restaurant_management_project.service.BranchService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int id) {
		return branchService.fetchBranchById(id);
	}

	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}

	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int oldId, @RequestBody Branch newBranch) {
		return branchService.updateBranch(oldId, newBranch);
	}

	@GetMapping("/fetchAllBranchs")
	public ResponseEntity<ResponseStructure1<Branch>> fetchAllBranchs() {
		return branchService.fetchAllBranchs();
	}

	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int addressId,
			@RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}

	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(@RequestParam int managerId,
			@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}

	@PutMapping("/addExistingMenuToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(@RequestParam int menuId,
			@RequestParam int branchId) {
		return branchService.addExistingMenuToExistingBranch(menuId, branchId);
	}

	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(@RequestParam int branchId,
			@RequestBody Address address) {
		return branchService.addNewAddressToExistingBranch(branchId, address);
	}

	@PutMapping("/addNewManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(@RequestParam int branchId,
			@RequestBody Manager manager) {
		return branchService.addNewManagerToExistingBranch(branchId, manager);
	}

	@PutMapping("/addNewMenuToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(@RequestParam int branchId, @RequestBody Menu menu) {
		return branchService.addNewMenuToExistingBranch(branchId, menu);
	}

	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(@RequestParam int employeeId,
			@RequestParam int branchId) {
		return branchService.addExistingEmployeeToExistingBranch(employeeId, branchId);
	}

	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(@RequestParam int branchId,
			@RequestBody Employee employee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, employee);
	}

	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(@RequestParam int customerId,
			@RequestParam int branchId) {
		return branchService.addExistingCustomerToExistingBranch(customerId, branchId);
	}

	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(@RequestBody Customer customer,
			@RequestParam int branchId) {
		return branchService.addNewCustomerToExistingBranch(customer, branchId);
	}
}
