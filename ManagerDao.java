package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Manager;
import com.qsp.restaurant_management_project.repo.ManagerRepo;

@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int id) {
		Optional<Manager> manager = managerRepo.findById(id);
		if (manager.isEmpty()) {
			return null;
		} else {
			return manager.get();
		}
	}

	public Manager deleteManager(int id) {
		Manager manager = fetchManagerById(id);
		managerRepo.delete(manager);
		return manager;
	}

	public Manager updateManager(int oldId, Manager newManager) {
		newManager.setManagerId(oldId);
		return managerRepo.save(newManager);
	}

	public List<Manager> fetchAllManagers() {
		return managerRepo.findAll();
	}

}
