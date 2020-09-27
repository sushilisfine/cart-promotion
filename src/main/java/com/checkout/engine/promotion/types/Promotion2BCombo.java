package com.checkout.engine.promotion.types;

import org.springframework.stereotype.Component;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.Promotion;

@Component
public class Promotion2BCombo implements Promotion {

	private final double comboPrice = 45.0;
	private final int comboCount = 2;

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
