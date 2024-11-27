package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class BothIdsAreNotFound extends RuntimeException {
	private String message = "Both Id's are not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
