package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Food;
import com.qsp.restaurant_management_project.dto.Menu;
import com.qsp.restaurant_management_project.repo.MenuRepo;

@Repository
public class MenuDao {
	@Autowired
	MenuRepo menuRepo;
	@Autowired
	FoodDao foodDao;

	public Menu saveMenu(Menu menu) {
		return menuRepo.save(menu);
	}

	public Menu fetchMenuById(int id) {
		Optional<Menu> menu = menuRepo.findById(id);
		if (menu.isEmpty()) {
			return null;
		} else {
			return menu.get();
		}
	}

	public Menu deleteMenu(int id) {
		Menu menu = fetchMenuById(id);
		menuRepo.delete(menu);
		return menu;
	}

	public Menu updateMenu(int oldId, Menu newMenu) {
		newMenu.setMenuId(oldId);
		return menuRepo.save(newMenu);
	}

	public List<Menu> fetchAllMenus() {
		return menuRepo.findAll();
	}

	public Menu addExistingFoodToExistingMenu(int foodId, int menuId) {
		Menu menu = fetchMenuById(menuId);
		Food food = foodDao.fetchFoodById(menuId);
		List<Food> list = menu.getFood();
		list.add(food);
		menu.setFood(list);
		return saveMenu(menu);
	}

	public Menu addNewFoodToExistingMenu(int menuId, Food food) {
		Menu menu = fetchMenuById(menuId);
		List<Food> list = menu.getFood();
		list.add(food);
		menu.setFood(list);
		return saveMenu(menu);
	}
}
