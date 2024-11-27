package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_project.dao.AddressDao;
import com.qsp.restaurant_management_project.dao.BranchDao;
import com.qsp.restaurant_management_project.dao.CustomerDao;
import com.qsp.restaurant_management_project.dao.EmployeeDao;
import com.qsp.restaurant_management_project.dao.ManagerDao;
import com.qsp.restaurant_management_project.dao.MenuDao;
import com.qsp.restaurant_management_project.dto.Address;
import com.qsp.restaurant_management_project.dto.Branch;
import com.qsp.restaurant_management_project.dto.Customer;
import com.qsp.restaurant_management_project.dto.Employee;
import com.qsp.restaurant_management_project.dto.Manager;
import com.qsp.restaurant_management_project.dto.Menu;
import com.qsp.restaurant_management_project.exception.AddressIdNotFound;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.BranchIdNotFound;
import com.qsp.restaurant_management_project.exception.CustomerIdNotFound;
import com.qsp.restaurant_management_project.exception.EmployeeIdNotFound;
import com.qsp.restaurant_management_project.exception.ManagerIdNotFound;
import com.qsp.restaurant_management_project.exception.MenuIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	@Autowired
	ResponseStructure1<Branch> responseStructure1;

	@Autowired
	AddressDao addressDao;

	@Autowired
	MenuDao menuDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Instered data from DataBase");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int id) {
		Branch branch = branchDao.fetchBranchById(id);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(branchDao.fetchBranchById(id));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		Branch branch = branchDao.fetchBranchById(id);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Delete data from DataBase");
			responseStructure.setData(branchDao.deleteBranch(id));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int oldId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Update data from DataBase");
			responseStructure.setData(branchDao.updateBranch(oldId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Branch>> fetchAllBranchs() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(branchDao.fetchAllBranchs());
		return new ResponseEntity<ResponseStructure1<Branch>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch != null) {
			if (address != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Address into Branch data from DataBase");
				responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else {
				throw new AddressIdNotFound();
			}
		} else if (branch == null && address == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int managerId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerById(managerId);
		if (branch != null) {
			if (manager != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Manager into Branch data from DataBase");
				responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else {
				throw new ManagerIdNotFound();
			}
		} else if (branch == null && manager == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(int menuId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Menu menu = menuDao.fetchMenuById(menuId);
		if (branch != null) {
			if (menu != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Menu into Branch data from DataBase");
				responseStructure.setData(branchDao.addExistingMenuToExistingBranch(menuId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new MenuIdNotFound();
			}
		} else if (branch == null && menu == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId, Address address) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			if (address != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Address into Branch data from DataBase");
				responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new AddressIdNotFound();
			}
		} else if (branch == null && address == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(int branchId, Manager manager) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			if (manager != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Manager into Branch data from DataBase");
				responseStructure.setData(branchDao.addNewManagerToExistingBranch(branchId, manager));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new ManagerIdNotFound();
			}
		} else if (branch == null && manager == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(int branchId, Menu menu) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			if (menu != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Menu into Branch data from DataBase");
				responseStructure.setData(branchDao.addNewMenuToExistingBranch(branchId, menu));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new MenuIdNotFound();
			}
		} else if (branch == null && menu == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (branch != null) {
			if (employee != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Employee into Branch data from DataBase");
				responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(employeeId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new EmployeeIdNotFound();
			}
		} else if (branch == null && employee == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(int branchId, Employee employee) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			if (employee != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Employee into Branch data from DataBase");
				responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, employee));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new EmployeeIdNotFound();
			}
		} else if (branch == null && employee == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int customerId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (branch != null) {
			if (customer != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Customer into Branch data from DataBase");
				responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(customerId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new CustomerIdNotFound();
			}
		} else if (branch == null && customer == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(Customer customer, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			if (customer != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Customer into Branch data from DataBase");
				responseStructure.setData(branchDao.addNewCustomerToExistingBranch(customer, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else

			{
				throw new CustomerIdNotFound();
			}
		} else if (branch == null && customer == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

}
