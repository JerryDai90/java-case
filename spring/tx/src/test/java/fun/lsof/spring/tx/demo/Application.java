package fun.lsof.spring.tx.demo;


//import fun.lsof.spring.tx.demo.config.Configuration;
import fun.lsof.spring.tx.demo.example.RequiresNewTest;
import fun.lsof.spring.tx.demo.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class Application {

    AnnotationConfigApplicationContext applicationContext;

    @Before
    public void before() {
//        applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
    }


//    @Test
//    public void test() {
//
//        UserService bean = applicationContext.getBean(UserService.class);
//        bean.initTable();
//        bean.addUser();
//        bean.addUser();
//        System.out.println(bean.queryAll());
//
//    }

    @Test
    public void test() {
        RequiresNewTest bean = applicationContext.getBean(RequiresNewTest.class);
        bean.t1();


    }



}
