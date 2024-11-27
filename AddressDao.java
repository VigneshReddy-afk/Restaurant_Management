package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_project.dto.Address;
import com.qsp.restaurant_management_project.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address fetchAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (address.isEmpty()) {
			return null;
		} else {
			return address.get();
		}

	}

	public Address deleteAddress(int id) {
		Address address = fetchAddressById(id);
		addressRepo.delete(address);
		return address;
	}

	public Address updateAddress(int oldId, Address newAddress) {
		newAddress.setAddressId(oldId);
		return addressRepo.save(newAddress);
	}

	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
