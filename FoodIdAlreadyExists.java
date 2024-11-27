package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class FoodIdAlreadyExists extends RuntimeException {
	private String message = "FoodID Already Exists";

	public String getMessage() {
		return message;
	}

}
