package domain.payment;

import java.util.Map;

import domain.menu.Menu;
import domain.order.OrderCount;
import domain.userselect.PaymentType;

/**
 * 결제 수단과 치킨 구매 수량을 고려하여 최종 결제 금액을 계산하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class PaymentRule {
	private static final int CHICKEN_DISCOUNT_UNIT = 10;
	private static final int CHICKEN_DISCOUNT_PRICE = 10_000;

	private final Map<Menu, OrderCount> orders;

	public PaymentRule(final Map<Menu, OrderCount> orders) {
		this.orders = orders;
	}

	public int calculateTotalPrice(final PaymentType paymentType) {
		int originalPrice = calculateOriginalPrice();
		int chickenDiscountedPrice = calculateChickenDiscountedPrice(originalPrice);
		return paymentType.calculateCashDiscountedPrice(chickenDiscountedPrice);
	}

	private int calculateOriginalPrice() {
		return orders.entrySet()
				.stream()
				.mapToInt(order -> order.getKey().calculatePrice(order.getValue()))
				.sum();
	}

	private int calculateChickenDiscountedPrice(final int price) {
		return price - calculateChickenDiscountPrice();
	}

	private int calculateChickenDiscountPrice() {
		int chickenCount = calculateTotalChickenCount();
		return (chickenCount / CHICKEN_DISCOUNT_UNIT) * CHICKEN_DISCOUNT_PRICE;
	}

	private int calculateTotalChickenCount() {
		return orders.entrySet()
				.stream()
				.filter(order -> order.getKey().isChicken())
				.mapToInt(order -> order.getValue().getCount())
				.sum();
	}
}
