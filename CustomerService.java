package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.CustomerDao;
import com.qsp.restaurant_management_project.dao.FoodOrderDao;
import com.qsp.restaurant_management_project.dto.Customer;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.CustomerIdNotFound;
import com.qsp.restaurant_management_project.exception.FoodOrderIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructure1<Customer> responseStructure1;
	@Autowired
	FoodOrderDao foodOrderDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Instered data from DataBase");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int id) {
		Customer customer = customerDao.fetchCustomerById(id);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(customerDao.fetchCustomerById(id));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		Customer customer = customerDao.fetchCustomerById(id);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Delete data from DataBase");
			responseStructure.setData(customerDao.deleteCustomer(id));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int oldId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(oldId);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Update data from DataBase");
			responseStructure.setData(customerDao.updateCustomer(oldId, newCustomer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Customer>> fetchAllCustomers() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(customerDao.fetchAllCustomers());
		return new ResponseEntity<ResponseStructure1<Customer>>(responseStructure1, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(int foodOrderId,
			int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (customer != null) {
			if (foodOrder != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted FoodOrder into Customer data from DataBase");
				responseStructure.setData(customerDao.addExistingFoodOrderToExistingCustomer(foodOrderId, customerId));
				return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
			} else {
				throw new FoodOrderIdNotFound();
			}
		} else if (customer == null && foodOrder == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(int customerId,
			FoodOrder foodOrder) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			if (foodOrder != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new FoodOrder into Customer data from DataBase");
				responseStructure.setData(customerDao.addNewFoodOrderToExistingCustomer(customerId, foodOrder));
				return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
			} else {
				throw new FoodOrderIdNotFound();
			}
		} else if (customer == null && foodOrder == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new CustomerIdNotFound();
		}
	}
}
