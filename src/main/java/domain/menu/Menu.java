package domain.menu;

import domain.order.OrderCount;

/**
 * 판매중인 메뉴 하나를 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isSameNumber(final int menuNumber) {
        return number == menuNumber;
    }

    public boolean isChicken() {
        return category.isChicken();
    }

    public int calculatePrice(final OrderCount orderCount) {
        return orderCount.calculatePrice(price);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
