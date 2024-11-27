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
import com.qsp.restaurant_management_project.dto.Manager;
import com.qsp.restaurant_management_project.service.ManagerService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int id) {
		return managerService.fetchManagerById(id);
	}

	@DeleteMapping("/deleteManager")
	public ResponseEntity<ResponseStructure<Manager>> deleteManager(@RequestParam int id) {
		return managerService.deleteManager(id);
	}

	@PutMapping("/updateManager")
	public ResponseEntity<ResponseStructure<Manager>> updateManager(@RequestParam int oldId,
			@RequestBody Manager newManager) {
		return managerService.updateManager(oldId, newManager);
	}

	@GetMapping("/fetchAllManagers")
	public ResponseEntity<ResponseStructure1<Manager>> fetchAllManagers() {
		return managerService.fetchAllManagers();
	}
}
