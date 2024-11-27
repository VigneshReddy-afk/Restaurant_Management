package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class BranchIdAlreadyExists extends RuntimeException {
	private String message = "BranchID Already Exists";

	public String getMessage() {
		return message;
	}

}
