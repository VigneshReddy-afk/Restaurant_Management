package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class PaymentIdNotFound extends RuntimeException {
	private String message = "PaymentId is not Found in the DataBase";

	public String getMessage() {
		return message;
	}

}
