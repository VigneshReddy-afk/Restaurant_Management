package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.FoodOrderDao;
import com.qsp.restaurant_management_project.dao.PaymentDao;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.dto.Payment;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.FoodOrderIdNotFound;
import com.qsp.restaurant_management_project.exception.PaymentIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class FoodOrderService {
	@Autowired
	FoodOrderDao foodOrderDao;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<FoodOrder> responseStructure;

	@Autowired
	ResponseStructure1<FoodOrder> responseStructure1;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Instered data from DataBase");
		responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> fetchFoodOrderById(int id) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(id);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(foodOrderDao.fetchFoodOrderById(id));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(id);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Delete data from DataBase");
			responseStructure.setData(foodOrderDao.deleteFoodOrder(id));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int oldId, FoodOrder newFoodOrder) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(oldId);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Update data from DataBase");
			responseStructure.setData(foodOrderDao.updateFoodOrder(oldId, newFoodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<FoodOrder>> fetchAllFoodOrders() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(foodOrderDao.fetchAllFoodOrders());
		return new ResponseEntity<ResponseStructure1<FoodOrder>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> addExistingPaymentToExistingFoodOrder(int paymentId,
			int foodOrderId) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (foodOrder != null) {
			if (payment != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Payment into FoodOrder data from DataBase");
				responseStructure.setData(foodOrderDao.addExistingPaymentToExistingFoodOrder(paymentId, foodOrderId));
				return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
			} else {
				throw new PaymentIdNotFound();
			}
		} else if (foodOrder == null && payment == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> addNewPaymentToExistingFoodOrder(int foodOrderId,
			Payment payment) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (foodOrder != null) {
			if (payment != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Payment into FoodOrder data from DataBase");
				responseStructure.setData(foodOrderDao.addNewPaymentToExistingFoodOrder(foodOrderId, payment));
				return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
			} else {
				throw new PaymentIdNotFound();
			}
		} else if (foodOrder == null && payment == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new FoodOrderIdNotFound();
		}
	}
}
