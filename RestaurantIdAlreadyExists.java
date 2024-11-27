package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class RestaurantIdAlreadyExists extends RuntimeException {
	private String message = "RestaurantID Already Exists";

	public String getMessage() {
		return message;
	}

}
