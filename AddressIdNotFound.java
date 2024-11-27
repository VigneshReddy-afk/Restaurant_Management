package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class AddressIdNotFound extends RuntimeException {
	private String message = "AddressId is Not Found in the DataBase";

	public String getMessage() {
		return message;
	}
}
