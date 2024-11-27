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
import com.qsp.restaurant_management_project.dto.Food;
import com.qsp.restaurant_management_project.dto.Menu;
import com.qsp.restaurant_management_project.service.MenuService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class MenuController {

	@Autowired
	MenuService menuService;

	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}

	@GetMapping("/fetchMenuById")
	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(@RequestParam int id) {
		return menuService.fetchMenuById(id);
	}

	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int id) {
		return menuService.deleteMenu(id);
	}

	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int oldId, @RequestBody Menu newMenu) {
		return menuService.updateMenu(oldId, newMenu);
	}

	@GetMapping("/fetchAllMenus")
	public ResponseEntity<ResponseStructure1<Menu>> fetchAllMenus() {
		return menuService.fetchAllMenus();
	}

	@PutMapping("/addExistingFoodToExistingMenu")
	public ResponseEntity<ResponseStructure<Menu>> addExistingFoodToExistingMenu(int foodId, int menuId) {
		return menuService.addExistingFoodToExistingMenu(foodId, menuId);
	}

	@PutMapping("/addNewFoodToExistingMenu")
	public ResponseEntity<ResponseStructure<Menu>> addNewFoodToExistingMenu(int menuId, Food food) {
		return menuService.addNewFoodToExistingMenu(menuId, food);
	}
}
