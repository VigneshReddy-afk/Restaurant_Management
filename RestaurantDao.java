package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Branch;
import com.qsp.restaurant_management_project.dto.Restaurant;
import com.qsp.restaurant_management_project.repo.RestaurantRepo;

@Repository
public class RestaurantDao {
	@Autowired
	RestaurantRepo restaurantRepo;
	@Autowired
	BranchDao branchDao;

	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}

	public Restaurant fetchByIdRestaurant(int id) {
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if (restaurant.isEmpty()) {
			return null;
		} else {
			return restaurant.get();
		}
	}

	public Restaurant deleteRestaurant(int id) {
		Restaurant restaurant = fetchByIdRestaurant(id);
		restaurantRepo.delete(restaurant);
		return restaurant;
	}

	public Restaurant updateRestaurant(int oldId, Restaurant newRestaurant) {
		newRestaurant.setRestaurantId(oldId);
		return restaurantRepo.save(newRestaurant);
	}

	public List<Restaurant> fetchAllRestaurants() {
		return restaurantRepo.findAll();
	}

	public Restaurant addExistingBranchToExisitingRestaurant(int branchId, int restaurantId) {
		Restaurant restaurant = fetchByIdRestaurant(restaurantId);
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Branch> list = restaurant.getBranch();
		list.add(branch);
		restaurant.setBranch(list);
		return saveRestaurant(restaurant);
	}

	public Restaurant addNewBranchToExisitingRestaurant(int restaurantId, Branch branch) {
		Restaurant restaurant = fetchByIdRestaurant(restaurantId);
		List<Branch> list = restaurant.getBranch();
		list.add(branch);
		restaurant.setBranch(list);
		return saveRestaurant(restaurant);
	}

}
