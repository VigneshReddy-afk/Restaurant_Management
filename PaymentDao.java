package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.Payment;
import com.qsp.restaurant_management_project.repo.PaymentRepo;

@Repository
public class PaymentDao {

	@Autowired
	PaymentRepo paymentRepo;

	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	public Payment fetchPaymentById(int id) {
		Optional<Payment> payment = paymentRepo.findById(id);
		if (payment.isEmpty()) {
			return null;
		} else {
			return payment.get();
		}
	}

	public Payment deletePayment(int id) {
		Payment payment = fetchPaymentById(id);
		paymentRepo.delete(payment);
		return payment;
	}

	public Payment updatePayment(int oldId, Payment newPayment) {
		newPayment.setPaymentId(oldId);
		return paymentRepo.save(newPayment);
	}

	public List<Payment> fetchAllPayments() {
		return paymentRepo.findAll();
	}
}
