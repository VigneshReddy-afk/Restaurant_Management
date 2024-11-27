package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class FoodOrderIdAlreadyExists extends RuntimeException {
	private String message = "FoodOrderID Already Exists";

	public String getMessage() {
		return message;
	}

}
