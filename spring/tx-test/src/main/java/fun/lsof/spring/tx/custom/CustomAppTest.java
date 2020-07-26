package fun.lsof.spring.tx.custom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomAppTest {

    public static ClassPathXmlApplicationContext context;

    public CustomAppTest() {
        context = new ClassPathXmlApplicationContext("classpath:spring-tx-custom.xml");
    }

    public static void main(String[] args) {
        CustomAppTest main = new CustomAppTest();
        DaoServer bean = context.getBean(DaoServer.class);
        bean.insert();




        System.exit(1);


    }

}
