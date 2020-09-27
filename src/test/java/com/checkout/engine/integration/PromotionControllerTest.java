package com.checkout.engine.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.checkout.engine.entities.dto.CartDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PromotionControllerTest extends CartEngineApplicationTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

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
		cart.setSkuA(5);
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
	public void test0Checkout() throws Exception {
		String uri = "/api/v1/checkout";

		CartDTO cartObj = cartObj0();

		String inputJson = super.mapToJson(cartObj);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int httpStatusCode = mvcResult.getResponse().getStatus();
		assertEquals(httpStatusCode, 200);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);

		assertEquals(Double.parseDouble(content), 0.0, 0);

	}

	@Test
	public void test1Checkout() throws Exception {
		String uri = "/api/v1/checkout";

		CartDTO cartObj = cartObj1();

		String inputJson = super.mapToJson(cartObj);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int httpStatusCode = mvcResult.getResponse().getStatus();
		assertEquals(httpStatusCode, 200);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);

		assertEquals(Double.parseDouble(content), 100.0, 0);

	}

	@Test
	public void test2Checkout() throws Exception {
		String uri = "/api/v1/checkout";

		CartDTO cartObj = cartObj2();

		String inputJson = super.mapToJson(cartObj);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int httpStatusCode = mvcResult.getResponse().getStatus();
		assertEquals(httpStatusCode, 200);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);

		assertEquals(Double.parseDouble(content), 370.0, 0);

	}

	@Test
	public void test3Checkout() throws Exception {
		String uri = "/api/v1/checkout";

		CartDTO cartObj = cartObj3();

		String inputJson = super.mapToJson(cartObj);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int httpStatusCode = mvcResult.getResponse().getStatus();
		assertEquals(httpStatusCode, 200);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);

		assertEquals(Double.parseDouble(content), 280.0, 0);

	}
}