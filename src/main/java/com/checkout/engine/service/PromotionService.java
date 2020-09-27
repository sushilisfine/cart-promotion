package com.checkout.engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.category.PromotionCategory;
import com.checkout.engine.promotion.category.PromotionFactory;

@Service
public class PromotionService {

	@Autowired
	PromotionFactory promotionFactory;

	public Double calculateTotal(CartDTO cart) {

		String promotionPackage = cart.getPromotionPackage();

		// default promotion if none selected from clients end
		if (promotionPackage == null)
			promotionPackage = "P1";

		PromotionCategory promotionCategory = promotionFactory.getPromotionCategory(cart.getPromotionPackage());

		return promotionCategory.applyPromotions(cart);
	}

}
