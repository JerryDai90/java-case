package fun.lsof.spring.tx.demo;

import fun.lsof.spring.tx.demo.config.SpringJunitTest;
import fun.lsof.spring.tx.demo.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseTest extends SpringJunitTest {

    @Autowired
    JdbcTemplate template;

    @Autowired
    UserService userService;

    @Test
    public void test1(){

//        template.execute("111");

        userService.initTable();
        userService.addUser();
        System.out.println(userService.queryAll());


    }


}
