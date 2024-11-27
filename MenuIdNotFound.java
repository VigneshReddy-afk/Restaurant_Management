package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class MenuIdNotFound extends RuntimeException {
	private String message = "MenuId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
