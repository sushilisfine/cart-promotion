package com.checkout.engine.promotion.category;

import org.springframework.stereotype.Component;

@Component
public class PromotionFactory {

	public PromotionCategory getPromotionCategory(String promotionType) {

		PromotionPackage promotionCategory = PromotionPackage.valueOf(promotionType);

		return promotionCategory.getCategory();
	}

}
