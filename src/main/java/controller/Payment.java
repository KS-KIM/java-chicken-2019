package controller;

import domain.menu.Menus;
import domain.table.Table;
import domain.table.Tables;
import domain.userselect.PaymentType;
import view.InputView;
import view.OutputView;

/**
 * 결제를 담당하는 컨트롤러
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Payment {
	private final Tables tables;
	private final Menus menus;

	public Payment(Tables tables, Menus menus) {
		this.tables = tables;
		this.menus = menus;
	}

	public void run() {
		if (!tables.hasUnpaidTable()) {
			OutputView.printUnpaidTableNotFoundMessage();
			return;
		}
		Table table = getUnpaidTableByTableNumber();
		OutputView.printOrders(table);
		PaymentType paymentType = InputView.inputPaymentMethod();
		int totalPaymentMoney = table.payment(paymentType);
		OutputView.printTotalPaymentMoney(totalPaymentMoney);
	}

	private Table getUnpaidTableByTableNumber() {
		OutputView.printTables(tables);
		try {
			int tableNumber = InputView.inputTableNumber();
			return tables.findTableByTableNumber(tableNumber);
		} catch (IllegalArgumentException e) {
			return getUnpaidTableByTableNumber();
		}
	}
}
