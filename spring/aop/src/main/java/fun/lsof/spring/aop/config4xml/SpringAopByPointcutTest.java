package fun.lsof.spring.aop.config4xml;

import fun.lsof.spring.aop.common.BookShopService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopByPointcutTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:fun/lsof/spring/aop/config4xml/spring-aop-by-pointcut.xml");

        BookShopService bean = context.getBean(BookShopService.class);

        bean.deleteBook();

        System.out.println(bean.getClass() + ": updateBookInfo");

        //没有保存
        bean.queryBook();

        System.out.println(bean);

    }

}
