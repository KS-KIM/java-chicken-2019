package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 치킨집 내의 모든 테이블을 제공하는 저장소
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-26
 */
public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}
