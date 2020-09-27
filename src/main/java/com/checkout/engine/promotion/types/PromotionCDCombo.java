package com.checkout.engine.promotion.types;

import org.springframework.stereotype.Component;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.Promotion;

@Component
public class PromotionCDCombo implements Promotion {

	// Price of combo when combined
	private final double comboPrice = 30.0;

	/*
	 * if C & D SKU's available , Calculate combo cost and set the remaining C & D
	 * respectively in the Cart Object
	 */
	@Override
	public Double apply(CartDTO cart) {
		// TODO Auto-generated method stub

		if (cart.getSkuC() > 0 && cart.getSkuD() > 0) {

			double totalAfterCombo = 0.0;

			int totalCombos = cart.getSkuC() < cart.getSkuD() ? cart.getSkuC() : cart.getSkuD();

			totalAfterCombo += totalCombos * comboPrice;

			cart.setSkuC(cart.getSkuC() - totalCombos);
			cart.setSkuD(cart.getSkuD() - totalCombos);

			return totalAfterCombo;
		}

		return 0.0;
	}

}
