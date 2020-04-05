package fun.lsof.spring.aop.dynamicproxy.jdk;

import fun.lsof.spring.aop.common.BookShopService;
import fun.lsof.spring.aop.config4xml.advice.MethodAdvice;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;


/**
 * 使用硬编码的方式来实现AOP（ProxyFactory）.
 *
 * @author jerry
 * @date 2020 -03-28 13:57:05
 */
public class SpringAopHardCodedByJdkProxyTest {


    public static void useAdvisor() {
        ProxyFactory factoryBean = new ProxyFactory();

        //设置代理对象
        factoryBean.setTarget(new Chrome());
        factoryBean.setInterfaces(IBrowser.class);

        //使用表达式模式来匹配需要 增强的方法已经类，和 spring-aop-by-pointcut.xml 的配置可以达到相同的效果
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setExpression("execution(* *.delete*()) or execution(* *.save*())");
        pointcutAdvisor.setAdvice(new MethodAdvice());


        factoryBean.addAdvisor(pointcutAdvisor);

        IBrowser bean2 = (IBrowser) factoryBean.getProxy();

        bean2.visitInternet();
        bean2.saveFile();

    }

    public static void main(String[] args) {
        useAdvisor();
    }


}
