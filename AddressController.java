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
import com.qsp.restaurant_management_project.dto.Address;
import com.qsp.restaurant_management_project.service.AddressService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int id) {
		return addressService.fetchAddressById(id);
	}

	@DeleteMapping("/deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return addressService.deleteAddress(id);
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int oldId,
			@RequestBody Address newAddress) {
		return addressService.updateAddress(oldId, newAddress);
	}

	@GetMapping("/fetchAllAddress")
	public ResponseEntity<ResponseStructure1<Address>> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

}
