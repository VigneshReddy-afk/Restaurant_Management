package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.qsp.restaurant_management_project.dao.ManagerDao;
import com.qsp.restaurant_management_project.dto.Manager;
import com.qsp.restaurant_management_project.exception.ManagerIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructure1<Manager> responseStructure1;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted data from DataBase");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int id) {
		Manager manager = managerDao.fetchManagerById(id);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Found the data from DataBase");
			responseStructure.setData(managerDao.fetchManagerById(id));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManager(int id) {
		Manager manager = managerDao.fetchManagerById(id);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(managerDao.deleteManager(id));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManager(int oldId, Manager newManager) {
		Manager manager = managerDao.fetchManagerById(oldId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Updated data from DataBase");
			responseStructure.setData(managerDao.updateManager(oldId, newManager));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Manager>> fetchAllManagers() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(managerDao.fetchAllManagers());
		return new ResponseEntity<ResponseStructure1<Manager>>(responseStructure1, HttpStatus.FOUND);
	}
}
