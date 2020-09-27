package com.checkout.engine.promotion.category;

import com.checkout.engine.entities.dto.CartDTO;

public interface PromotionCategory {

	default Double leftOverSkuTotal(CartDTO cart) {
		return 0.0;
	}

	public Double applyPromotions(CartDTO cart);
}
