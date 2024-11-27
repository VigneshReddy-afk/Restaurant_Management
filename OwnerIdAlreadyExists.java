package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class OwnerIdAlreadyExists extends RuntimeException {
	private String message = "OwnerID Already Exists";

	public String getMessage() {
		return message;
	}

}
