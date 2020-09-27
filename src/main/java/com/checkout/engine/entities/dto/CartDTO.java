package com.checkout.engine.entities.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {

	private int skuA;
	private int skuB;
	private int skuC;
	private int skuD;

	private String promotionPackage;
}
