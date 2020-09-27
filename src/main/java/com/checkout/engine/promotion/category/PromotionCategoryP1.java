package com.checkout.engine.promotion.category;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.types.Promotion2BCombo;
import com.checkout.engine.promotion.types.Promotion3ACombo;
import com.checkout.engine.promotion.types.PromotionCDCombo;

public class PromotionCategoryP1 implements PromotionCategory {
	
	Promotion3ACombo promotion3ACombo = new Promotion3ACombo();
	Promotion2BCombo promotion2BCombo = new Promotion2BCombo();
	PromotionCDCombo promotionCDCombo = new PromotionCDCombo();

	public Double applyPromotions(CartDTO cart) {

		Double total = 0.0;
		total += promotion3ACombo.apply(cart);
		total += promotion2BCombo.apply(cart);
		total += promotionCDCombo.apply(cart);

		total += leftOverSkuTotal(cart);

		return total;
	}}
