package com.checkout.engine.promotion.types;

import org.springframework.stereotype.Component;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.Promotion;

@Component
public class Promotion3ACombo implements Promotion {

	// Price of combo when combined
	private final double comboPrice = 130.0;

	// count of A to combined to create promotional combo
	private final int comboCount = 3;

	/*
	 * if 3 A SKU's combination available , Calculate combo cost and set the
	 * remaining A i.e reminder when divided by combo count in the Cart Object
	 */
	@Override
	public Double apply(CartDTO cart) {
		// TODO Auto-generated method stub

		if (cart.getSkuA() > 0) {

			double totalAfterCombo = 0.0;

			int totalCombos = cart.getSkuA() / comboCount;
			int leftOverSku = cart.getSkuA() % comboCount;

			totalAfterCombo += totalCombos * comboPrice;

			cart.setSkuA(leftOverSku);

			return totalAfterCombo;
		}

		return 0.0;
	}

}
