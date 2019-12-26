package domain.menu;

/**
 * 판매하는 상품의 카테고리를 의미하는 열거형
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public enum Category {
    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public boolean isChicken() {
        return this.equals(CHICKEN);
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
