package com.checkout.engine.sku;

import org.springframework.stereotype.Component;

@Component
public class SKU_D implements SKU {

	private final Double price = 15.0;

	public Double getPrice() {
		return price;
	}

}
