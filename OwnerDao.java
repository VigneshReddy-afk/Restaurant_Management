package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_project.dto.Owner;
import com.qsp.restaurant_management_project.dto.Restaurant;
import com.qsp.restaurant_management_project.repo.OwnerRepo;

@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	RestaurantDao restaurantDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int id) {
		Optional<Owner> owner = ownerRepo.findById(id);
		if (owner.isEmpty()) {
			return null;
		} else {
			return owner.get();
		}
	}


	public Owner deleteOwner(int id) {
		Owner owner = fetchOwnerById(id);
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner updateOwner(int oldId, Owner newOwner) {
		newOwner.setOwnerId(oldId);
		return ownerRepo.save(newOwner);
	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}

	public Owner addExistingRestaurantToExistingOwner(int restaurantId, int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		Restaurant restaurant = restaurantDao.fetchByIdRestaurant(restaurantId);
		owner.setRestaurant(restaurant);
		return saveOwner(owner);
	}

	public Owner addNewRestaurantToExistingOwner(int ownerId, Restaurant restaurant) {
		Owner owner = fetchOwnerById(ownerId);
		owner.setRestaurant(restaurant);
		return saveOwner(owner);
	}
}
