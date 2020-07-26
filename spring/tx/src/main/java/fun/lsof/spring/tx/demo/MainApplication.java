package fun.lsof.spring.tx.demo;

import fun.lsof.spring.tx.demo.user.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MainApplication {

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-datasource.xml");


        new Thread(new Runnable() {
            @Override
            public void run() {
                UserService userService = context.getBean(UserService.class);
//
                userService.initTable();

                userService.addUser();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    UserService userService = context.getBean(UserService.class);
                    System.out.println(userService.queryAll());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();
//        System.exit(0);
    }

}


