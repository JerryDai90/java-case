package fun.lsof.spring.aop.dynamicproxy.cglib;

import fun.lsof.spring.aop.config4xml.advice.MethodAdvice;
import fun.lsof.spring.aop.common.Chrome;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.core.DebuggingClassWriter;


/**
 * 使用硬编码的方式来实现AOP（ProxyFactory）.
 *
 * @author jerry
 * @date 2020 -03-28 13:57:05
 */
public class SpringAopHardCodedByCGlibTest {


    public static void useAdvisor() {

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/jerry/Private/gitHub/mySelf/java-case/spring/aop/src/test/java");


        ProxyFactory factoryBean = new ProxyFactory();

        //设置代理对象
        factoryBean.setTarget(new Chrome());
//        factoryBean.setInterfaces(IBrowser.class);

        factoryBean.setOptimize(true);

        //使用表达式模式来匹配需要 增强的方法已经类，和 spring-aop-by-pointcut.xml 的配置可以达到相同的效果
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setExpression("execution(* *.delete*()) or execution(* *.save*())");
        pointcutAdvisor.setAdvice(new MethodAdvice());


        factoryBean.addAdvisor(pointcutAdvisor);

        Chrome bean2 = (Chrome) factoryBean.getProxy();

//        bean2.visitInternet();
        bean2.saveFile();
//        bean2.hashCode();

//        System.out.printf(bean2.getClass().toString());

    }

    public static void main(String[] args) throws Exception{
        useAdvisor();
    }


}
