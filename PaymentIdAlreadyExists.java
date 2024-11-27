package com.qsp.restaurant_management_project.exception;

@SuppressWarnings("serial")
public class PaymentIdAlreadyExists extends RuntimeException {
	private String message = "PaymentID Already Exists";

	public String getMessage() {
		return message;
	}

}
