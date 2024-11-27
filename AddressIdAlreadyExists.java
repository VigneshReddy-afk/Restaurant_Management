package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class AddressIdAlreadyExists extends RuntimeException {
	private String message = "AddressID Already Exists";

	public String getMessage() {
		return message;
	}

}
