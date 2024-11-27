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
import com.qsp.restaurant_management_project.dto.Food;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.service.FoodService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class FoodController {
	@Autowired
	FoodService foodService;

	@PostMapping("/saveFood")
	public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	}

	@GetMapping("/fetchFoodById")
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(@RequestParam int id) {
		return foodService.fetchFoodById(id);
	}

	@DeleteMapping("/deleteFood")
	public ResponseEntity<ResponseStructure<Food>> deleteFood(@RequestParam int id) {
		return foodService.deleteFood(id);
	}

	@PutMapping("/updateFood")
	public ResponseEntity<ResponseStructure<Food>> updateFood(@RequestParam int oldId, @RequestBody Food newFood) {
		return foodService.updateFood(oldId, newFood);
	}

	@GetMapping("/fetchAllFoods")
	public ResponseEntity<ResponseStructure1<Food>> fetchAllFoods() {
		return foodService.fetchAllFoods();
	}

	@PutMapping("/addExistingFoodOrderToExistingFood")
	public ResponseEntity<ResponseStructure<Food>> addExistingFoodOrderToExistingFood(@RequestParam int foodId,
			@RequestParam int foodOrderId) {
		return foodService.addExistingFoodOrderToExistingFood(foodId, foodOrderId);
	}

	@PutMapping("/addNewFoodOrderToExistingFood")
	public ResponseEntity<ResponseStructure<Food>> addNewFoodOrderToExistingFood(@RequestParam int foodId,
			@RequestBody FoodOrder foodOrder) {
		return foodService.addNewFoodOrderToExistingFood(foodId, foodOrder);
	}
}
