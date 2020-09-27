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
}