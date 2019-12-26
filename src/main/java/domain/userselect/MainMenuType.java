package domain.userselect;

import java.util.stream.Stream;

/**
 * 메인에서 선택할 수 있는 메뉴를 의미하는 열거형
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public enum MainMenuType {
	ADD_ORDER("1"),
	PAYMENT("2"),
	EXIT_PROGRAM("3");

	private final String input;

	MainMenuType(final String input) {
		this.input = input;
	}

	public static MainMenuType of(final String input) {
		return Stream.of(MainMenuType.values())
				.filter(menuType -> menuType.input.equals(input))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴를 선택하셨습니다."));
	}
}
