package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class OwnerIdNotFound extends RuntimeException {

	private String message = "OwnerId is Not Found in the DataBase";

	public String getMessage() {
		return message;
	}
}
