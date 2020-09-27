package com.checkout.engine.integration.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.checkout.engine.entities.dto.CartDTO;
import com.checkout.engine.promotion.types.Promotion2BCombo;
import com.checkout.engine.promotion.types.Promotion3ACombo;
import com.checkout.engine.promotion.types.PromotionCDCombo;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PromotionCombo {

	@Autowired
	private Promotion3ACombo promotion3ACombo;

	private CartDTO cartObj0() {
		CartDTO cart = new CartDTO();
		cart.setPromotionPackage("P1");

		return cart;
	}

	private CartDTO cartObj1() {
		CartDTO cart = new CartDTO();
		cart.setSkuA(1);
		cart.setSkuB(1);
		cart.setSkuC(1);
		cart.setPromotionPackage("P1");

		return cart;
	}

	private CartDTO cartObj2() {
		CartDTO cart = new CartDTO();
		cart.setSkuA(6);
		cart.setSkuB(5);
		cart.setSkuC(1);
		cart.setPromotionPackage("P1");

		return cart;
	}

	private CartDTO cartObj3() {
		CartDTO cart = new CartDTO();
		cart.setSkuA(3);
		cart.setSkuB(5);
		cart.setSkuC(1);
		cart.setSkuD(1);
		cart.setPromotionPackage("P1");

		return cart;
	}

	@Test
	public void test0Promotio3A() {
		CartDTO cartObj = cartObj0();
		assertThat(promotion3ACombo.apply(cartObj)).isEqualTo(0.0);

	}

	@Test
	public void test1Promotion3A() {
		CartDTO cartObj = cartObj1();
		assertThat(promotion3ACombo.apply(cartObj)).isEqualTo(0.0);

	}

	@Test
	public void test2Promotion3A() {
		CartDTO cartObj = cartObj2();
		assertThat(promotion3ACombo.apply(cartObj)).isEqualTo(260.0);

	}

	@Test
	public void test3Promotion3A() {
		CartDTO cartObj = cartObj3();
		assertThat(promotion3ACombo.apply(cartObj)).isEqualTo(130.0);

	}
}
