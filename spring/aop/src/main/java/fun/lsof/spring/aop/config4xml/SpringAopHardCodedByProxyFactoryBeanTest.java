package fun.lsof.spring.aop.config4xml;

import fun.lsof.spring.aop.config4xml.advice.MethodAdvice;
import fun.lsof.spring.aop.common.BookShopService;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * 使用硬编码的方式来实现AOP（ProxyFactoryBean）.
 *
 * @author jerry
 * @date 2020 -03-28 13:57:31
 */
public class SpringAopHardCodedByProxyFactoryBeanTest {


    public static void print(BookShopService bean) {
        System.out.println(bean.getClass() + ": updateBookInfo");

        bean.deleteBook();
        //没有保存
        bean.queryBook();
    }


    public static void useAdvisor() {
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();

        //设置代理对象
        factoryBean.setTarget(new BookShopService());

        //使用表达式模式来匹配需要 增强的方法已经类，和 spring-aop-by-pointcut.xml 的配置可以达到相同的效果
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setExpression("execution(* *.delete*()) or execution(* *.update*())");
        pointcutAdvisor.setAdvice(new MethodAdvice());

        factoryBean.addAdvisor(pointcutAdvisor);

        BookShopService bean2 = (BookShopService) factoryBean.getObject();
        print(bean2);
    }

    public static void proxyAllMethod() {
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();

        //设置代理对象
        factoryBean.setTarget(new BookShopService());

        //直接可以设置监听所有执行的方法
        factoryBean.addAdvice(new MethodAdvice());

        BookShopService bean2 = (BookShopService) factoryBean.getObject();
        print(bean2);
    }


    public static void main(String[] args) {
        useAdvisor();
        proxyAllMethod();
    }

}
