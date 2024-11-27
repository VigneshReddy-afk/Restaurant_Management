package com.qsp.restaurant_management_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.restaurant_management_project.dto.Payment;
import com.qsp.restaurant_management_project.service.PaymentService;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}

	@GetMapping("/fetchPaymentById")
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int id) {
		return paymentService.fetchPaymentById(id);
	}

	@DeleteMapping("/deletePayment")
	public ResponseEntity<ResponseStructure<Payment>> deletePayment(@RequestParam int id) {
		return paymentService.deletePayment(id);
	}

	@PutMapping("/updatePayment")
	public ResponseEntity<ResponseStructure<Payment>> updatePayment(@RequestParam int oldId,
			@RequestBody Payment newPayment) {
		return paymentService.updatePayment(oldId, newPayment);
	}

	@GetMapping("/fetchAllPayments")
	public ResponseEntity<ResponseStructure1<Payment>> fetchAllPayments() {
		return paymentService.fetchAllPayments();
	}
}
