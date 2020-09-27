package com.checkout.engine.promotion;

import com.checkout.engine.entities.dto.CartDTO;

public interface Promotion {
	public Double apply(CartDTO cart);
}
