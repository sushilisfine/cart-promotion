package com.checkout.engine.sku;

import org.springframework.stereotype.Component;

@Component
public class SKU_B implements SKU {

	private final Double price= 30.0;

	public Double getPrice() {

		return price;
	}

}
