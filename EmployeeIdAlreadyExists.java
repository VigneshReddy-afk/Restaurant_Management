package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class EmployeeIdAlreadyExists extends RuntimeException {
	private String message = "EmployeeID Already Exists";

	public String getMessage() {
		return message;
	}
}
