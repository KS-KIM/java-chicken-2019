package domain.order;

/**
 * 주문의 개수를 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class OrderCount {
	private static final int MIN_ORDER_COUNT = 1;
	private static final int MAX_ORDER_COUNT = 99;

	private final int count;

	public OrderCount(final int count) {
		validateOrderCount(count);
		this.count = count;
	}

	private void validateOrderCount(final int count) {
		if (count < MIN_ORDER_COUNT || count > MAX_ORDER_COUNT) {
			throw new IllegalArgumentException("주문할 수 없는 수량입니다.");
		}
	}

	public boolean canAddOrder(final OrderCount that) {
		int orderSum = this.count + that.count;
		return orderSum >= MIN_ORDER_COUNT && orderSum <= MAX_ORDER_COUNT;
	}

	public OrderCount mergeOrder(final OrderCount that) {
		int orderSum = this.count + that.count;
		return new OrderCount(orderSum);
	}

	public int getCount() {
		return count;
	}

	public int calculatePrice(final int price) {
		return price * count;
	}
}
