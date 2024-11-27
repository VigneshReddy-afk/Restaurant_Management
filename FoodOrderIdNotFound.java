package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class FoodOrderIdNotFound extends RuntimeException {
	private String message = "FoodOrderId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
