package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.OwnerDao;
import com.qsp.restaurant_management_project.dao.RestaurantDao;
import com.qsp.restaurant_management_project.dto.Owner;
import com.qsp.restaurant_management_project.dto.Restaurant;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_project.exception.RestaurantIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructure1<Owner> responseStructure1;
	@Autowired
	RestaurantDao restaurantDao;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Insterd data from DataBase");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int id) {
		Owner owner = ownerDao.fetchOwnerById(id);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Found the data from DataBase");
			responseStructure.setData(ownerDao.fetchOwnerById(id));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwner(int id) {
		Owner owner = ownerDao.fetchOwnerById(id);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(ownerDao.deleteOwner(id));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwner(int oldId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully update data from DataBase");
			responseStructure.setData(ownerDao.updateOwner(oldId, newOwner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Owner>> fetchAllOwner() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(ownerDao.fetchAllOwner());
		return new ResponseEntity<ResponseStructure1<Owner>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExistingOwner(int restaurantId,
			int ownerId) {

		Owner owner = ownerDao.fetchOwnerById(ownerId);
		Restaurant restaurant = restaurantDao.fetchByIdRestaurant(restaurantId);
		if (owner != null) {
			if (restaurant != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Restaurant to Owner data from DataBase");
				responseStructure.setData(ownerDao.addExistingRestaurantToExistingOwner(restaurantId, ownerId));
				return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
			} else {
				throw new RestaurantIdNotFound();
			}
		} else if (owner == null && restaurant == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(int ownerId,
			Restaurant restaurant) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			if (restaurant != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Restaurant to Owner data from DataBase");
				responseStructure.setData(ownerDao.addNewRestaurantToExistingOwner(ownerId, restaurant));
				return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
			} else {
				throw new RestaurantIdNotFound();
			}
		} else if (owner == null && restaurant == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new OwnerIdNotFound();
		}
	}
}
