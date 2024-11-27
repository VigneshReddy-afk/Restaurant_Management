package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_project.dto.Address;
import com.qsp.restaurant_management_project.dto.Branch;
import com.qsp.restaurant_management_project.dto.Customer;
import com.qsp.restaurant_management_project.dto.Employee;
import com.qsp.restaurant_management_project.dto.Manager;
import com.qsp.restaurant_management_project.dto.Menu;
import com.qsp.restaurant_management_project.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	MenuDao menuDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int id) {
		Optional<Branch> branch = branchRepo.findById(id);
		if (branch.isEmpty()) {
			return null;
		} else {
			return branch.get();
		}
	}

	public Branch deleteBranch(int id) {
		Branch branch = fetchBranchById(id);
		branchRepo.delete(branch);
		return branch;
	}

	public Branch updateBranch(int oldId, Branch newBranch) {
		newBranch.setBranchId(oldId);
		return branchRepo.save(newBranch);
	}

	public List<Branch> fetchAllBranchs() {
		return branchRepo.findAll();
	}

	public Branch addExistingAddressToExistingBranch(int addressId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addExistingManagerToExistingBranch(int managerId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerById(managerId);
		branch.setManager(manager);
		return saveBranch(branch);
	}

	public Branch addExistingMenuToExistingBranch(int menuId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Menu menu = menuDao.fetchMenuById(menuId);
		branch.setMenu(menu);
		return saveBranch(branch);
	}

	public Branch addNewAddressToExistingBranch(int branchId, Address address) {
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addNewManagerToExistingBranch(int branchId, Manager manager) {
		Branch branch = fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}

	public Branch addNewMenuToExistingBranch(int branchId, Menu menu) {
		Branch branch = fetchBranchById(branchId);
		branch.setMenu(menu);
		return saveBranch(branch);
	}

	public Branch addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		List<Employee> list = branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}

	public Branch addNewEmployeeToExistingBranch(int branchId, Employee employee) {
		Branch branch = fetchBranchById(branchId);
		List<Employee> list = branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}

	public Branch addExistingCustomerToExistingBranch(int customerId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		List<Customer> list = branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}

	public Branch addNewCustomerToExistingBranch(Customer customer, int branchId) {
		Branch branch = fetchBranchById(branchId);
		List<Customer> list = branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
}
