package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class BranchIdNotFound extends RuntimeException {
	private String message = "BranchId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
