package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.BranchDao;
import com.qsp.restaurant_management_project.dao.RestaurantDao;
import com.qsp.restaurant_management_project.dto.Branch;
import com.qsp.restaurant_management_project.dto.Restaurant;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.BranchIdNotFound;
import com.qsp.restaurant_management_project.exception.RestaurantIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class RestaurantService {
	@Autowired
	RestaurantDao restaurantDao;

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Restaurant> responseStructure;

	@Autowired
	ResponseStructure1<Restaurant> responseStructure1;

	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(Restaurant restaurant) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Instered data from DataBase");
		responseStructure.setData(restaurantDao.saveRestaurant(restaurant));
		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Restaurant>> fetchByIdRestaurant(int id) {
		Restaurant restaurant = restaurantDao.fetchByIdRestaurant(id);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(restaurantDao.fetchByIdRestaurant(id));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurant(int id) {
		Restaurant restaurant = restaurantDao.fetchByIdRestaurant(id);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(restaurantDao.deleteRestaurant(id));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(int oldId, Restaurant newRestaurant) {
		Restaurant restaurant = restaurantDao.fetchByIdRestaurant(oldId);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated data from DataBase");
			responseStructure.setData(restaurantDao.updateRestaurant(oldId, newRestaurant));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Restaurant>> fetchAllRestaurants() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(restaurantDao.fetchAllRestaurants());
		return new ResponseEntity<ResponseStructure1<Restaurant>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExisitingRestaurant(int branchId,
			int restaurantId) {
		Restaurant restaurant = restaurantDao.fetchByIdRestaurant(restaurantId);
		Branch branch = branchDao.fetchBranchById(branchId);
		if (restaurant != null) {
			if (branch != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Branch into Restaurant data from DataBase");
				responseStructure.setData(restaurantDao.addExistingBranchToExisitingRestaurant(branchId, restaurantId));
				return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
			} else {
				throw new BranchIdNotFound();
			}
		} else if (restaurant == null && branch == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new RestaurantIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExisitingRestaurant(int restaurantId,
			Branch branch) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Inserted new Branch into Restaurant data from DataBase");
		responseStructure.setData(restaurantDao.addNewBranchToExisitingRestaurant(restaurantId, branch));
		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
	}

}
