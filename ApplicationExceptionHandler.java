package com.qsp.restaurant_management_project.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.qsp.restaurant_management_project.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(BothIdsAreNotFound.class)
	public ResponseEntity<ResponseStructure<String>> BothIdsAreNotFound(BothIdsAreNotFound bothIdsAreNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(bothIdsAreNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFpund(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RestaurantIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> restaurantIdNotFound(RestaurantIdNotFound restaurantIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(restaurantIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(employeeIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> managerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(managerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MenuIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> menuIdNotFound(MenuIdNotFound menuIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(menuIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> foodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(foodIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FoodOrderIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderIdNotFound(FoodOrderIdNotFound foodOrderIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(foodOrderIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> addressIdAlreadyExists(
			AddressIdAlreadyExists addressIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(addressIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> branchIdAlreadyExists(
			BranchIdAlreadyExists branchIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(branchIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> customerIdAlreadyExists(
			CustomerIdAlreadyExists customerIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(customerIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdAlreadyExists(
			EmployeeIdAlreadyExists employeeIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(employeeIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FoodIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> foodIdAlreadyExists(
			FoodIdAlreadyExists foodIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(foodIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FoodOrderIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderIdAlreadyExists(
			FoodOrderIdAlreadyExists foodOrderIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(foodOrderIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ManagerIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> managerIdAlreadyExists(
			ManagerIdAlreadyExists managerIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(managerIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MenuIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> menuIdAlreadyExists(
			MenuIdAlreadyExists menuIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(menuIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OwnerIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdAlreadyExists(
			OwnerIdAlreadyExists ownerIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(ownerIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> paymentIdAlreadyExists(
			PaymentIdAlreadyExists paymentIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(paymentIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RestaurantIdAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> restaurantIdAlreadyExists(
			RestaurantIdAlreadyExists restaurantIdAlreadyExists) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Data Not Found from DataBase");
		responseStructure.setData(restaurantIdAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
}
