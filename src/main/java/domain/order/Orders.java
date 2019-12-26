package domain.order;

import java.util.LinkedHashMap;
import java.util.Map;

import domain.payment.PaymentRule;
import domain.userselect.PaymentType;
import domain.menu.Menu;

/**
 * 한 테이블이 가지는 여러개의 주문을 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Orders {
	private static final int EMPTY_ORDER = 0;

	private final Map<Menu, OrderCount> orders;

	public Orders() {
		this.orders = new LinkedHashMap<>();
	}

	public boolean hasAnyOrder() {
		return orders.size() > EMPTY_ORDER;
	}

	public boolean canAddOrder(final Menu menu, final OrderCount orderCount) {
		if (!orders.containsKey(menu)) {
			return true;
		}
		return orders.get(menu).canAddOrder(orderCount);
	}

	public void addOrder(final Menu menu, final OrderCount orderCount) {
		if (!orders.containsKey(menu)) {
			orders.put(menu, orderCount);
			return;
		}
		OrderCount mergedOrderCount = orders.get(menu).mergeOrder(orderCount);
		orders.replace(menu, mergedOrderCount);
	}

	public int payment(final PaymentType paymentType) {
		PaymentRule paymentPrice = new PaymentRule(orders);
		int paymentTotalMoney = paymentPrice.calculateTotalPrice(paymentType);
		orders.clear();
		return paymentTotalMoney;
	}

	public Map<Menu, OrderCount> getOrders() {
		return orders;
	}
}
