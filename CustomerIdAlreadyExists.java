package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class CustomerIdAlreadyExists extends RuntimeException {
	private String message = "CustomerID Already Exists";

	public String getMessage() {
		return message;
	}

}
