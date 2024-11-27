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
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.dto.Payment;
import com.qsp.restaurant_management_project.service.FoodOrderService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class FoodOrderController {
	@Autowired
	FoodOrderService foodOrderService;

	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}

	@GetMapping("/fetchFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> fetchFoodOrderById(@RequestParam int id) {
		return foodOrderService.fetchFoodOrderById(id);
	}

	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
		return foodOrderService.deleteFoodOrder(id);
	}

	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int oldId,
			@RequestBody FoodOrder newFoodOrder) {
		return foodOrderService.updateFoodOrder(oldId, newFoodOrder);
	}

	@GetMapping("/fetchAllFoodOrders")
	public ResponseEntity<ResponseStructure1<FoodOrder>> fetchAllFoodOrders() {
		return foodOrderService.fetchAllFoodOrders();
	}

	@PutMapping("/addExistingPaymentToExistingFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> addExistingPaymentToExistingFoodOrder(
			@RequestParam int paymentId, @RequestParam int foodOrderId) {
		return foodOrderService.addExistingPaymentToExistingFoodOrder(paymentId, foodOrderId);
	}

	@PutMapping("/addNewPaymentToExistingFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> addNewPaymentToExistingFoodOrder(@RequestParam int foodOrderId,
			@RequestBody Payment payment) {
		return foodOrderService.addNewPaymentToExistingFoodOrder(foodOrderId, payment);
	}
}
