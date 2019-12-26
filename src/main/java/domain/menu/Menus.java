package domain.menu;

import java.util.Collections;
import java.util.List;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Menus {
	private final List<Menu> menus;

	public Menus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Menu> getMenus() {
		return Collections.unmodifiableList(menus);
	}

	public Menu findMenuByMenuNumber(final int menuNumber) {
		return menus.stream()
				.filter(menu -> menu.isSameNumber(menuNumber))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
	}
}
