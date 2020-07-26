package fun.lsof.spring.tx.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void initTable() {
        jdbcTemplate.execute("CREATE TABLE `user` (  `id` varchar(128) , `name` varchar(128) ,`loginid` varchar(128) ) ");
    }


    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void addUser() {
        System.out.println(jdbcTemplate);
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[1];
        jdbcTemplate.execute("insert INTO user values('"+Math.random()+"', '"+stackTrace.getFileName()+"', '"+stackTrace.getMethodName()+"') ");
//        throw new NullPointerException();
    }


//    @Transactional
//    public void addUser2() {
//
//        jdbcTemplate.execute("insert INTO user values('22', '32', '42') ");
//        throw new RuntimeException();
//    }


    public List<Map<String, Object>> queryAll() {
        System.out.println("queryAll:"+jdbcTemplate);

        return jdbcTemplate.queryForList("select * from user");

    }


}
