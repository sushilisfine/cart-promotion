package com.checkout.engine.promotion.category;

import org.springframework.stereotype.Component;

@Component
public enum PromotionPackage {

	P1 {

		@Override
		public PromotionCategory getCategory() {
			// TODO Auto-generated method stub
			return new PromotionCategoryP1();
		}

	},
	P2 {

		@Override
		public PromotionCategory getCategory() {
			// TODO Auto-generated method stub
			return new PromotionCategoryP2();
		}

	};

	public abstract PromotionCategory getCategory();
}
