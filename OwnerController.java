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
import com.qsp.restaurant_management_project.dto.Owner;
import com.qsp.restaurant_management_project.dto.Restaurant;
import com.qsp.restaurant_management_project.service.OwnerService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int id) {
		return ownerService.fetchOwnerById(id);
	}

	@DeleteMapping("/deleteOwner")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwner(@RequestParam int id) {
		return ownerService.deleteOwner(id);
	}

	@PutMapping("/updateOwner")
	public ResponseEntity<ResponseStructure<Owner>> updateOwner(@RequestParam int oldId, @RequestBody Owner newOwner) {
		return ownerService.updateOwner(oldId, newOwner);
	}

	@GetMapping("/fetchAllOwner")
	public ResponseEntity<ResponseStructure1<Owner>> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@PutMapping("/addExistingRestaurantToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExistingOwner(@RequestParam int restaurantId,
			@RequestParam int ownerId) {
		return ownerService.addExistingRestaurantToExistingOwner(restaurantId, ownerId);
	}

	@PutMapping("/addNewRestaurantToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(@RequestParam int ownerId,
			@RequestBody Restaurant restaurant) {
		return ownerService.addNewRestaurantToExistingOwner(ownerId, restaurant);
	}
}
