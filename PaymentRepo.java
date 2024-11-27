package com.qsp.restaurant_management_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_project.dto.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
