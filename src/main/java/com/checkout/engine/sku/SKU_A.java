package com.checkout.engine.sku;

import org.springframework.stereotype.Component;

@Component
public class SKU_A implements SKU {

	private final Double price = 50.0;

	public Double getPrice() {
		return price;
	}

}
