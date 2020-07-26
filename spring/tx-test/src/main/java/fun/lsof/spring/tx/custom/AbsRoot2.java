package fun.lsof.spring.tx.custom;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AbsRoot2 {

    public static final AtomicInteger aId = new AtomicInteger();

    @Autowired
    protected JdbcTemp jdbcTemplate;

    public void insert() {
        jdbcTemplate.execute("INSERT INTO T_TEST VALUES(" + aId.getAndAdd(1) + ") ");
    }

    public void insertById(int... ids) {
        for (int id : ids) {
            jdbcTemplate.execute("INSERT INTO T_TEST VALUES(" + id + ") ");
        }
    }

    public void insert(int row) {
        for (int ix = 0; ix < row; ix++) {
            jdbcTemplate.execute("INSERT INTO T_TEST VALUES(" + aId.getAndAdd(1) + ") ");
        }
    }

    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM T_TEST");
        return maps;
    }

    public int countAll() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM T_TEST", Integer.class);
    }

    public boolean hasId(int id) {
        Integer integer = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM T_TEST WHERE ID=" + id, Integer.class);
        return integer != 0;
    }

    public void delete() {
        jdbcTemplate.execute("DELETE FROM T_TEST");
    }

    public void delete(int id) {
        jdbcTemplate.execute("DELETE FROM T_TEST WHERE ID=" + id);
    }


    public <T>T getProxy(T t){
        return (T)AopContext.currentProxy();
    }
}
