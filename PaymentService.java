package com.qsp.restaurant_management_project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.restaurant_management_project.dao.PaymentDao;
import com.qsp.restaurant_management_project.dto.Payment;
import com.qsp.restaurant_management_project.exception.PaymentIdNotFound;
import com.qsp.restaurant_management_project.util.ResponseStructure;
import com.qsp.restaurant_management_project.util.ResponseStructure1;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;
	@Autowired
	ResponseStructure<Payment> responseStructure;
	@Autowired
	ResponseStructure1<Payment> responseStructure1;

	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted data from DataBase");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int id) {
		Payment payment = paymentDao.fetchPaymentById(id);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetch the data from DataBase");
			responseStructure.setData(paymentDao.fetchPaymentById(id));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> deletePayment(int id) {
		Payment payment = paymentDao.fetchPaymentById(id);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted data from DataBase");
			responseStructure.setData(paymentDao.deletePayment(id));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> updatePayment(int oldId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Updated data from DataBase");
			responseStructure.setData(paymentDao.updatePayment(oldId, newPayment));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Payment>> fetchAllPayments() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully FOUND ALL the data from DataBase");
		responseStructure1.setData(paymentDao.fetchAllPayments());
		return new ResponseEntity<ResponseStructure1<Payment>>(responseStructure1, HttpStatus.FOUND);
	}
}
