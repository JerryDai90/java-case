package fun.lsof.spring.tx.test;


//import fun.lsof.spring.tx.demo.config.Configuration;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApplication {

//    AnnotationConfigApplicationContext applicationContext;

    public static ClassPathXmlApplicationContext context;

    public MainApplication() {
        context = new ClassPathXmlApplicationContext("classpath:spring-tx-test.xml");
    }


    public static void main(String[] args) {
        MainApplication main = new MainApplication();

        RequiresNewTest bean = context.getBean(RequiresNewTest.class);

        try {
            bean.t1();
        }catch (Exception e){
            e.printStackTrace();
        }



//        System.out.println(bean.hasId(1));
//        System.out.println(bean.hasId(2));
//
//        System.out.println(bean.queryAll());

        System.exit(1);
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

//    @Test
//    public void test() {
//        RequiresNewTest bean = applicationContext.getBean(RequiresNewTest.class);
//        bean.t1();
//
//
//    }


}
