package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.FoodDao;
import com.qsp.restaurant_management_project.dao.MenuDao;
import com.qsp.restaurant_management_project.dto.Food;
import com.qsp.restaurant_management_project.dto.Menu;
import com.qsp.restaurant_management_project.exception.BothIdsAreNotFound;
import com.qsp.restaurant_management_project.exception.FoodIdNotFound;
import com.qsp.restaurant_management_project.exception.MenuIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class MenuService {
	@Autowired
	MenuDao menuDao;

	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Menu> responseStructure;

	@Autowired
	ResponseStructure1<Menu> responseStructure1;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted data from DataBase");
		responseStructure.setData(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(int id) {
		Menu menu = menuDao.fetchMenuById(id);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully find data from DataBase");
			responseStructure.setData(menuDao.fetchMenuById(id));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		Menu menu = menuDao.fetchMenuById(id);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(menuDao.deleteMenu(id));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int oldId, Menu newMenu) {
		Menu menu = menuDao.fetchMenuById(oldId);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Updated data from DataBase");
			responseStructure.setData(menuDao.updateMenu(oldId, newMenu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else

		{
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Menu>> fetchAllMenus() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(menuDao.fetchAllMenus());
		return new ResponseEntity<ResponseStructure1<Menu>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Menu>> addExistingFoodToExistingMenu(int foodId, int menuId) {
		Food food = foodDao.fetchFoodById(foodId);
		Menu menu = menuDao.fetchMenuById(menuId);
		if (menu != null) {
			if (food != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted Food into Menu data from DataBase");
				responseStructure.setData(menuDao.addExistingFoodToExistingMenu(foodId, menuId));
				return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			} else {
				throw new FoodIdNotFound();
			}
		} else if (food == null && menu == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> addNewFoodToExistingMenu(int menuId, Food food) {
		Menu menu = menuDao.fetchMenuById(menuId);
		if (menu != null) {
			if (food != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Inserted new Food into Menu data from DataBase");
				responseStructure.setData(menuDao.addNewFoodToExistingMenu(menuId, food));
				return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			} else {
				throw new FoodIdNotFound();
			}
		} else if (food == null && menu == null) {
			throw new BothIdsAreNotFound();
		} else {
			throw new MenuIdNotFound();
		}
	}
}
