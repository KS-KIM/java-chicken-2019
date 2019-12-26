package view;

import java.util.Scanner;

import domain.order.OrderCount;
import domain.userselect.MainMenuType;
import domain.userselect.PaymentType;

public class InputView {
    private static final String MAIN_MENU_SELECT_GUIDE_MESSAGE = "## 메인화면\n"
                    + "1: 주문등록\n"
                    + "2: 결제하기\n"
                    + "3: 프로그램 종료\n"
                    + "## 원하시는 기능을 선택하세요.";
    private static final String TABLE_SELECT_GUIDE_MESSAGE = "## 주문할 테이블을 선택하세요.";
    private static final String MENU_SELECT_GUIDE_MESSAGE = "## 등록할 메뉴를 선택하세요.";
    private static final String ORDER_COUNT_GUIDE_MESSAGE = "## 메뉴의 수량을 입력하세요.";
    private static final String PAYMENT_METHOD_GUIDE_MESSAGE = "## 신용카드는 1번, 현금은 2번";
    private static final String INVALID_INPUT_ALERT_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static MainMenuType inputMainMenu() {
        try {
            System.out.println(MAIN_MENU_SELECT_GUIDE_MESSAGE);
            String input = SCANNER.nextLine();
            return MainMenuType.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_ALERT_MESSAGE);
            return inputMainMenu();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println(TABLE_SELECT_GUIDE_MESSAGE);
            String input = SCANNER.nextLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_ALERT_MESSAGE);
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println(MENU_SELECT_GUIDE_MESSAGE);
            String input = SCANNER.nextLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_ALERT_MESSAGE);
            return inputTableNumber();
        }
    }

    public static OrderCount inputOrderCount() {
        try {
            System.out.println(ORDER_COUNT_GUIDE_MESSAGE);
            String input = SCANNER.nextLine();
            return new OrderCount(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_ALERT_MESSAGE);
            return inputOrderCount();
        }
    }

    public static PaymentType inputPaymentMethod() {
        try {
            System.out.println(PAYMENT_METHOD_GUIDE_MESSAGE);
            String input = SCANNER.nextLine();
            return PaymentType.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_ALERT_MESSAGE);
            return inputPaymentMethod();
        }
    }
}
