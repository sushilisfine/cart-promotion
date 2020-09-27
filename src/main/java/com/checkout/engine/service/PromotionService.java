package com.checkout.engine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.category.PromotionCategory;
import com.checkout.engine.promotion.category.PromotionFactory;

@Service
public class PromotionService {

	@Autowired
	PromotionFactory promotionFactory;

	public Map<String, Double> calculateTotal(CartDTO cart) {

		String promotionPackage = cart.getPromotionPackage();

		// default promotion if none selected from clients end
		if (promotionPackage == null)
			promotionPackage = "P1";

		// Factory method to get the object of the promotional package to be applied
		PromotionCategory promotionCategory = promotionFactory.getPromotionCategory(cart.getPromotionPackage());

		Map<String, Double> totalPrice = new HashMap<>();
		totalPrice.put("total", promotionCategory.applyPromotions(cart));
		return totalPrice;
	}

}
