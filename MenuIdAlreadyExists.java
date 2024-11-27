package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class MenuIdAlreadyExists extends RuntimeException {
	private String message = "MenuID Already Exists";

	public String getMessage() {
		return message;
	}

}
