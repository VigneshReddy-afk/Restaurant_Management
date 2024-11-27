package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class RestaurantIdNotFound extends RuntimeException{
	
	private String message = "RestaurantId is Not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
