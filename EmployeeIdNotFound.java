package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class EmployeeIdNotFound extends RuntimeException {
	private String message = "EmployeeId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
