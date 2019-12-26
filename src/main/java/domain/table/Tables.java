package domain.table;

import java.util.Collections;
import java.util.List;

/**
 * 치킨집 내의 모든 테이블을 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Tables {
	private final List<Table> tables;

	public Tables(final List<Table> tables) {
		this.tables = tables;
	}

	public List<Table> getTables() {
		return Collections.unmodifiableList(tables);
	}

	public boolean hasUnpaidTable() {
		return tables.stream().anyMatch(Table::hasAnyOrder);
	}

	public Table findTableByTableNumber(final int tableNumber) {
		return tables.stream()
				.filter(table -> table.isSameNumber(tableNumber))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블입니다"));
	}
}
