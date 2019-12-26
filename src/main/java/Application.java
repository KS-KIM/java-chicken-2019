import controller.ChickenHouse;
import domain.menu.MenuRepository;
import domain.menu.Menus;
import domain.table.TableRepository;
import domain.table.Tables;

/**
 * 프로그램을 실행하는 진입부
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class Application {
    public static void main(String[] args) {
        final Tables tables = new Tables(TableRepository.tables());
        final Menus menus = new Menus(MenuRepository.menus());
        ChickenHouse chickenHouse = new ChickenHouse(tables, menus);
        chickenHouse.run();
    }
}
