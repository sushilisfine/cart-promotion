package com.checkout.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.service.PromotionService;

@RestController
@RequestMapping("/api")
public class PromotionController {

	@Autowired
	PromotionService promotionService;

	@PostMapping(value = "/v1/checkout")
	public Double checkout(@RequestBody CartDTO cart) {
		return promotionService.calculateTotal(cart);
	}
}
