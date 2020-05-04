package fun.lsof.spring.aop.config4xml;

import fun.lsof.spring.aop.common.BookShopService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHandlerResolver extends DefaultNamespaceHandlerResolver {

    public TestHandlerResolver() {
    }

    public TestHandlerResolver(ClassLoader classLoader) {
        super(classLoader);
    }

    public TestHandlerResolver(ClassLoader classLoader, String handlerMappingsLocation) {
        super(classLoader, handlerMappingsLocation);
    }

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:fun/lsof/spring/aop/config4xml/spring-aop-by-proxyfactorybean.xml");
//
//        BookShopService bean = (BookShopService) context.getBean("factoryBean");
//        print(bean);
//
//        System.out.println("----------------------------------------");
//
//        //通过factoryBean 拿到具体的代理对象
//        ProxyFactoryBean pfb = (ProxyFactoryBean) context.getBean("&factoryBean");
//        BookShopService bean4pfb = (BookShopService) pfb.getObject();
//
//        print(bean4pfb);

        ///-------------------------手动编程方式实现配置 AOP 信息--------------------------------------------------------------------


        TestHandlerResolver df = new TestHandlerResolver(ClassLoader.getSystemClassLoader());

//        System.out.println(df);

        df.resolve("http://www.springframework.org/schema/aop");

    }

    @Override
    public String toString() {
        return "";
    }
}
