package com.checkout.engine.sku;

import org.springframework.stereotype.Component;

@Component
public class SKU_C implements SKU {

	private final Double price = 20.0;

	public Double getPrice() {

		return price;
	}

}
