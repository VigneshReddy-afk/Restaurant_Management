package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class ManagerIdNotFound extends RuntimeException {
	private String message = "ManagerId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
