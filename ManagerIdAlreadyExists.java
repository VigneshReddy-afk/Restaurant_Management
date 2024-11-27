package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class ManagerIdAlreadyExists extends RuntimeException {
	private String message = "ManagerID Already Exists";

	public String getMessage() {
		return message;
	}

}
