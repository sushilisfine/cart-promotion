package com.checkout.engine.promotion.types;

import org.springframework.stereotype.Component;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.Promotion;

@Component
public class PromotionCDCombo implements Promotion {

	private final double comboPrice = 30.0;

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
