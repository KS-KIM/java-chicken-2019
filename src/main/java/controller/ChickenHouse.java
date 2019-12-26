package controller;

import domain.menu.Menus;
import domain.table.Tables;
import domain.userselect.MainMenuType;
import view.InputView;
import view.OutputView;

/**
 * 메인 메뉴 선택에 따라 작동하는 컨트롤러
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class ChickenHouse {
	private final AddOrder addOrder;
	private final Payment payment;

	public ChickenHouse(Tables tables, Menus menus) {
		addOrder = new AddOrder(tables ,menus);
		payment = new Payment(tables, menus);
	}

	public void run() {
		while (true) {
			MainMenuType mainMenuType = InputView.inputMainMenu();
			delegateByMenuType(mainMenuType);
		}
	}

	private void delegateByMenuType(MainMenuType mainMenuType) {
		if (MainMenuType.ADD_ORDER.equals(mainMenuType)) {
			addOrder.run();
		}
		if (MainMenuType.PAYMENT.equals(mainMenuType)) {
			payment.run();
		}
		if (MainMenuType.EXIT_PROGRAM.equals(mainMenuType)) {
			OutputView.printExitMessage();
			System.exit(0);
		}
	}
}
