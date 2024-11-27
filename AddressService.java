package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.AddressDao;
import com.qsp.restaurant_management_project.dto.Address;
import com.qsp.restaurant_management_project.exception.AddressIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	@Autowired
	ResponseStructure1<Address> responseStructure1;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted data from DataBase");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int id) {
		Address address = addressDao.fetchAddressById(id);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(addressDao.fetchAddressById(id));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address = addressDao.fetchAddressById(id);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(addressDao.deleteAddress(id));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int oldId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Updated data from DataBase");
			responseStructure.setData(addressDao.updateAddress(oldId, newAddress));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Address>> fetchAllAddress() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(addressDao.fetchAllAddress());
		return new ResponseEntity<ResponseStructure1<Address>>(responseStructure1, HttpStatus.FOUND);
	}
}
