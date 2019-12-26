package domain.userselect;

import java.util.stream.Stream;

/**
 * 결제 수단을 의미하는 열거형
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public enum PaymentType {
	CREDIT_CARD("1", 1.00),
	CASH("2", 0.95);

	private final String input;
	private final double discountRate;

	PaymentType(final String input, final double discountRate) {
		this.input = input;
		this.discountRate = discountRate;
	}

	public int calculateCashDiscountedPrice(final int price) {
		return (int) (discountRate * price);
	}

	public static PaymentType of(final String input) {
		return Stream.of(PaymentType.values())
				.filter(paymentType -> paymentType.input.equals(input))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("잘못된 결제 타입을 입력하셨습니다."));
	}
}
