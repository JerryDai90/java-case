package fun.lsof.spring.aop.config4xml;

import fun.lsof.spring.aop.common.BookShopService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopByProxyFactoryBeanTest {


    public static void print(BookShopService bean) {
        System.out.println(bean.getClass() + ": updateBookInfo");

        bean.deleteBook();
        //没有保存
        bean.queryBook();
    }

    private static void getProxyFactoryBean(ClassPathXmlApplicationContext context) {
        System.out.println("-------------------结合xml配置，手动配置 AOP 信息-------------------");

        ProxyFactoryBean factoryBean = new ProxyFactoryBean();

        //可以基于容器来实例化 ProxyFactoryBean，
        //需要设置beanFactory，要不然无法查找到下面的bean信息
        factoryBean.setBeanFactory(context);
        factoryBean.setInterceptorNames("allAspect");
        factoryBean.setTargetName("bookShopService");

        BookShopService bean2 = (BookShopService) factoryBean.getObject();
        print(bean2);
    }

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:fun/lsof/spring/aop/config4xml/spring-aop-by-proxyfactorybean.xml");

        BookShopService bean = (BookShopService) context.getBean("factoryBean");
        print(bean);

        System.out.println("----------------------------------------");

        //通过factoryBean 拿到具体的代理对象
        ProxyFactoryBean pfb = (ProxyFactoryBean) context.getBean("&factoryBean");
        BookShopService bean4pfb = (BookShopService) pfb.getObject();

        print(bean4pfb);

        ///-------------------------手动编程方式实现配置 AOP 信息--------------------------------------------------------------------
    }



}
