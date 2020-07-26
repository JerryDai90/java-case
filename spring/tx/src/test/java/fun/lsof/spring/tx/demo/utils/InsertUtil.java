package fun.lsof.spring.tx.demo.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class InsertUtil {

    public static void initTable(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("CREATE TABLE T_TEST ( ID INT(10))");
    }


//    public static void addUser(JdbcTemplate jdbcTemplate) {
//        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[1];
//        jdbcTemplate.execute("INSERT INTO T_TEST VALUES('"+Math.random()+"', '"+stackTrace.getFileName()+"', '"+System.currentTimeMillis()+"') ");
//    }
//
//    public static List<Map<String, Object>> queryAll(JdbcTemplate jdbcTemplate) {
////        System.out.println("queryAll:"+jdbcTemplate);
//        return jdbcTemplate.queryForList("SELECT * FROM T_TEST");
//    }



}
