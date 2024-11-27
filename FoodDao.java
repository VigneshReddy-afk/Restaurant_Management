package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Food;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	@Autowired
	FoodOrderDao foodOrderDao;

	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}

	public Food fetchFoodById(int id) {
		Optional<Food> food = foodRepo.findById(id);
		if (food.isEmpty()) {
			return null;
		} else {
			return food.get();
		}
	}

	public Food deleteFood(int id) {
		Food food = fetchFoodById(id);
		foodRepo.delete(food);
		return food;
	}

	public Food updateFood(int oldId, Food newFood) {
		newFood.setFoodId(oldId);
		return foodRepo.save(newFood);
	}

	public List<Food> fetchAllFoods() {
		return foodRepo.findAll();
	}

	public Food addExistingFoodOrderToExistingFood(int foodId, int foodOrderId) {
		Food food = fetchFoodById(foodId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		List<FoodOrder> list = food.getFoodOrder();
		list.add(foodOrder);
		food.setFoodOrder(list);
		return saveFood(food);
	}

	public Food addNewFoodOrderToExistingFood(int foodId, FoodOrder foodOrder) {
		Food food = fetchFoodById(foodId);
		List<FoodOrder> list = food.getFoodOrder();
		list.add(foodOrder);
		food.setFoodOrder(list);
		return saveFood(food);
	}
}
