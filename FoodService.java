package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.FoodDao;
import com.qsp.restaurant_management_project.dao.FoodOrderDao;
import com.qsp.restaurant_management_project.dto.Food;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.FoodIdNotFound;
import com.qsp.restaurant_management_project.exception.FoodOrderIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	@Autowired
	FoodOrderDao foodOrderDao;
	@Autowired
	ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructure1<Food> responseStructure1;

	public ResponseEntity<ResponseStructure<Food>> saveFood(Food food) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted data from DataBase");
		responseStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(int id) {
		Food food = foodDao.fetchFoodById(id);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(foodDao.fetchFoodById(id));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> deleteFood(int id) {
		Food food = foodDao.fetchFoodById(id);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(foodDao.deleteFood(id));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> updateFood(int oldId, Food newFood) {
		Food food = foodDao.fetchFoodById(oldId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Updated data from DataBase");
			responseStructure.setData(foodDao.updateFood(oldId, newFood));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Food>> fetchAllFoods() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(foodDao.fetchAllFoods());
		return new ResponseEntity<ResponseStructure1<Food>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Food>> addExistingFoodOrderToExistingFood(int foodId, int foodOrderId) {
		Food food = foodDao.fetchFoodById(foodId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (food != null) {
			if (foodOrder != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted FoodOrder into Food data from DataBase");
				responseStructure.setData(foodDao.addExistingFoodOrderToExistingFood(foodId, foodOrderId));
				return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
			} else {
				throw new FoodOrderIdNotFound();
			}
		} else if (food == null && foodOrder == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> addNewFoodOrderToExistingFood(int foodId, FoodOrder foodOrder) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			if (foodOrder != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new FoodOrder into Food data from DataBase");
				responseStructure.setData(foodDao.addNewFoodOrderToExistingFood(foodId, foodOrder));
				return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
			} else {
				throw new FoodOrderIdNotFound();
			}
		} else if (food == null && foodOrder == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new FoodIdNotFound();
		}
	}

}
