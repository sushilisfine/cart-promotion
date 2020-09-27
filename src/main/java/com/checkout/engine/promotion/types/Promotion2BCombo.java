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
		return 0.0;
	}

}
