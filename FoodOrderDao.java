package com.qsp.restaurant_management_project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.restaurant_management_project.dto.FoodOrder;
import com.qsp.restaurant_management_project.dto.Payment;
import com.qsp.restaurant_management_project.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepo foodOrderRepo;
	@Autowired
	PaymentDao paymentDao;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}

	public FoodOrder fetchFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepo.findById(id);
		if (foodOrder.isEmpty()) {
			return null;
		} else {
			return foodOrder.get();
		}
	}

	public FoodOrder deleteFoodOrder(int id) {
		FoodOrder foodOrder = fetchFoodOrderById(id);
		foodOrderRepo.delete(foodOrder);
		return foodOrder;
	}

	public FoodOrder updateFoodOrder(int oldId, FoodOrder newFoodOrder) {
		newFoodOrder.setFoodOrderId(oldId);
		return foodOrderRepo.save(newFoodOrder);
	}

	public List<FoodOrder> fetchAllFoodOrders() {
		return foodOrderRepo.findAll();
	}

	public FoodOrder addExistingPaymentToExistingFoodOrder(int paymentId, int foodOrderId) {
		FoodOrder foodOrder = fetchFoodOrderById(foodOrderId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		foodOrder.setPaymant(payment);
		return saveFoodOrder(foodOrder);
	}

	public FoodOrder addNewPaymentToExistingFoodOrder(int foodOrderId, Payment payment) {
		FoodOrder foodOrder = fetchFoodOrderById(foodOrderId);
		foodOrder.setPaymant(payment);
		return saveFoodOrder(foodOrder);
	}
}
