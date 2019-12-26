package controller;

import domain.menu.Menu;
import domain.menu.Menus;
import domain.order.OrderCount;
import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

/**
 * 테이블에 판매한 항목을 추가하기 위한 컨트롤러
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class AddOrder {
	private final Tables tables;
	private final Menus menus;

	public AddOrder(Tables tables, Menus menus) {
		this.tables = tables;
		this.menus = menus;
	}

	public void run() {
		Table table = getTableByTableNumber();
		Menu menu = getMenuByMenuNumber();
		addOrder(table, menu);
	}

	private Table getTableByTableNumber() {
		OutputView.printTables(tables);
		try {
			int tableNumber = InputView.inputTableNumber();
			return tables.findTableByTableNumber(tableNumber);
		} catch (IllegalArgumentException e) {
			return getTableByTableNumber();
		}
	}

	private Menu getMenuByMenuNumber() {
		OutputView.printMenus(menus);
		try {
			int menuNumber = InputView.inputMenuNumber();
			return menus.findMenuByMenuNumber(menuNumber);
		} catch (IllegalArgumentException e) {
			return getMenuByMenuNumber();
		}
	}

	// FIXME: 2019-12-26 모든 항목을 99개씩 구입한 경우에 대해 예외처리가 되어있지 않음
	private void addOrder(Table table, Menu menu) {
		try {
			OrderCount orderCount = InputView.inputOrderCount();
			table.addOrder(menu, orderCount);
		} catch (IllegalArgumentException e) {
			OutputView.printOrderCountExceedMessage();
		}
	}
}
