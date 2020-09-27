package com.checkout.engine.promotion.types;

import org.springframework.stereotype.Component;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.Promotion;

@Component
public class Promotion2BCombo implements Promotion {

	// Price of combo when combined
	private final double comboPrice = 45.0;
	
	// count of B to combined to create promotional combo
	private final int comboCount = 2;

	/*
	 * if 2 B SKU's combination available , Calculate combo cost and set the
	 * remaining B i.e reminder when divided by combo count in the Cart Object
	 */
	@Override
	public Double apply(CartDTO cart) {
		// TODO Auto-generated method stub

		if (cart.getSkuB() > 0) {

			double totalAfterCombo = 0.0;

			int totalCombos = cart.getSkuB() / comboCount;
			int leftOverSku = cart.getSkuB() % comboCount;

			totalAfterCombo += totalCombos * comboPrice;

			cart.setSkuB(leftOverSku);

			return totalAfterCombo;
		}

		return 0.0;
	}

}
