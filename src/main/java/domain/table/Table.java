package domain.table;

import domain.menu.Menu;
import domain.order.OrderCount;
import domain.userselect.PaymentType;
import domain.order.Orders;

/**
 * 치킨집 내 테이블 하나를 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Table {
    private static final int MIN_TABLE_COUNT = 1;

    private final int number;
    private final Orders orders;

    public Table(final int number) {
        validateNumber(number);
        this.number = number;
        this.orders = new Orders();
    }

    private void validateNumber(final int number) {
        if (number < MIN_TABLE_COUNT) {
            throw new IllegalArgumentException("테이블 번호는 1부터 시작합니다.");
        }
    }

    public boolean isSameNumber(final int tableNumber) {
        return number == tableNumber;
    }

    public boolean hasAnyOrder() {
        return orders.hasAnyOrder();
    }

    public void addOrder(final Menu menu, final OrderCount orderCount) {
        orders.addOrder(menu, orderCount);
    }

    public int payment(final PaymentType paymentType) {
        return orders.payment(paymentType);
    }

    public Orders getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
