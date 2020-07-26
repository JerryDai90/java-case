package fun.lsof.spring.tx.test.config;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBConfig {

    public static String init(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("CREATE TABLE T_TEST ( ID INT(10))");
        return "";
    }

}
