package com.checkout.engine.promotion.category;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.types.Promotion2BCombo;
import com.checkout.engine.promotion.types.Promotion3ACombo;
import com.checkout.engine.promotion.types.PromotionCDCombo;

public class PromotionCategoryP1 implements PromotionCategory {

	public Double applyPromotions(CartDTO cart) {

		return 0.0;
	}

}
