package com.checkout.engine.promotion.category;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.sku.SKU_A;
import com.checkout.engine.sku.SKU_B;
import com.checkout.engine.sku.SKU_C;
import com.checkout.engine.sku.SKU_D;

public interface PromotionCategory {

	public static final SKU_A skuA = new SKU_A();

	public static final SKU_B skuB = new SKU_B();

	public static final SKU_C skuC = new SKU_C();

	public static final SKU_D skuD = new SKU_D();

	default Double leftOverSkuTotal(CartDTO cart) {

		double total = 0.0;

		total += cart.getSkuA() * skuA.getPrice();
		total += cart.getSkuB() * skuB.getPrice();
		total += cart.getSkuC() * skuC.getPrice();
		total += cart.getSkuD() * skuD.getPrice();

		return total;
	}

	public Double applyPromotions(CartDTO cart);

}
