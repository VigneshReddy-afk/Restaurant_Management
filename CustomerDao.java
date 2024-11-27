package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Customer;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	FoodOrderDao foodOrderDao;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchCustomerById(int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isEmpty()) {
			return null;
		} else {
			return customer.get();
		}
	}

	public Customer deleteCustomer(int id) {
		Customer customer = fetchCustomerById(id);
		customerRepo.delete(customer);
		return customer;
	}

	public Customer updateCustomer(int oldId, Customer newCustomer) {
		newCustomer.setCustomerId(oldId);
		return customerRepo.save(newCustomer);
	}

	public List<Customer> fetchAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer addExistingFoodOrderToExistingCustomer(int foodOrderId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		List<FoodOrder> list = customer.getFoodOrder();
		list.add(foodOrder);
		customer.setFoodOrder(list);
		return saveCustomer(customer);
	}

	public Customer addNewFoodOrderToExistingCustomer(int customerId, FoodOrder foodOrder) {
		Customer customer = fetchCustomerById(customerId);
		List<FoodOrder> list = customer.getFoodOrder();
		list.add(foodOrder);
		customer.setFoodOrder(list);
		return saveCustomer(customer);
	}
}
