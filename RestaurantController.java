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
import com.qsp.restaurant_management_project.dto.Branch;
import com.qsp.restaurant_management_project.dto.Restaurant;
import com.qsp.restaurant_management_project.service.RestaurantService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/saveRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.saveRestaurant(restaurant);
	}

	@GetMapping("/fetchByIdRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> fetchByIdRestaurant(@RequestParam int id) {
		return restaurantService.fetchByIdRestaurant(id);
	}

	@DeleteMapping("/deleteRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurant(@RequestParam int id) {
		return restaurantService.deleteRestaurant(id);
	}

	@PutMapping("/updateRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(@RequestParam int oldId,
			@RequestBody Restaurant newRestaurant) {
		return restaurantService.updateRestaurant(oldId, newRestaurant);
	}

	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<ResponseStructure1<Restaurant>> fetchAllRestaurants() {
		return restaurantService.fetchAllRestaurants();
	}

	@PutMapping("/addExistingBranchToExisitingRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExisitingRestaurant(
			@RequestParam int branchId, @RequestParam int restaurantId) {
		return restaurantService.addExistingBranchToExisitingRestaurant(branchId, restaurantId);
	}

	@PutMapping("/addNewBranchToExisitingRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExisitingRestaurant(
			@RequestParam int restaurantId, @RequestBody Branch branch) {
		return restaurantService.addNewBranchToExisitingRestaurant(restaurantId, branch);
	}
}
