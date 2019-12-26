package view;

import domain.menu.Menu;
import domain.menu.Menus;
import domain.order.OrderCount;
import domain.order.Orders;
import domain.table.Table;
import domain.table.Tables;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String SHOW_TABLES_MESSAGE = "## 테이블 목록";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_UNPAID_LINE = "└ ₩ ┘";
    private static final String ORDER_COUNT_EXCEED_MESSAGE = "## 구매할 수 있는 항목의 수를 초과했습니다. "
            + "메인으로 돌아갑니다.";
    private static final String UNPAID_TABLE_NOT_FOUND_MESSAGE = "## 결제할 수 있는 테이블이 없습니다.";
    private static final String PURCHASE_MENUS_GUIDE_MESSAGE = "## 구매 목록\n"
            + "종류 | 메뉴명 | 가격 | 수량";
    private static final String ORDER_FORMAT = "%s %d %d\n";
    private static final String TOTAL_PAYMENT_PRICE_FORMAT = "최종 결제 금액: %d원\n";
    private static final String EXIT_PROGRAM_MESSAGE = "## 프로그램을 종료합니다.";

    public static void printTables(final Tables tables) {
        printTables(tables.getTables());
    }

    public static void printMenus(final Menus menus) {
        printMenus(menus.getMenus());
    }

    public static void printOrders(final Table table) {
        Orders orders = table.getOrders();
        printOrders(orders);
    }

    public static void printOrderCountExceedMessage() {
        System.out.println(ORDER_COUNT_EXCEED_MESSAGE);
    }

    public static void printUnpaidTableNotFoundMessage() {
        System.out.println(UNPAID_TABLE_NOT_FOUND_MESSAGE);
    }

    public static void printTotalPaymentMoney(int totalMoney) {
        System.out.printf(TOTAL_PAYMENT_PRICE_FORMAT, totalMoney);
    }

    public static void printExitMessage() {
        System.out.println(EXIT_PROGRAM_MESSAGE);
    }

    private static void printTables(final List<Table> tables) {
        System.out.println(SHOW_TABLES_MESSAGE);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLines(tables);
    }

    private static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLines(final List<Table> tables) {
        for(Table table: tables) {
            printBottomLine(table);
        }
        System.out.println();
    }

    private static void printBottomLine(final Table table) {
        if (table.hasAnyOrder()) {
            System.out.print(BOTTOM_UNPAID_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printOrders(final Orders orders) {
        Map<Menu, OrderCount> menuOrders = orders.getOrders();
        System.out.println(PURCHASE_MENUS_GUIDE_MESSAGE);
        menuOrders.forEach(OutputView::printOrder);
    }

    private static void printOrder(final Menu menu, final OrderCount orderCount) {
        System.out.printf(ORDER_FORMAT, menu.getName(), menu.getPrice(), orderCount.getCount());
    }
}
