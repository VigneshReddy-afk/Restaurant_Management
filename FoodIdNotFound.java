package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class FoodIdNotFound extends RuntimeException {
	private String message = "FoodId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
