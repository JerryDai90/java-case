package fun.lsof.javacore.proxy.dynamic.aop;


import fun.lsof.javacore.proxy.dynamic.Bus;
import fun.lsof.javacore.proxy.dynamic.ICar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 测试ProxyFactory.
 *
 * @author jerry
 * @date 2020 -04-27 13:41:04
 */
public class ProxyFactoryTest {


    public static void main(String[] args) throws Exception {

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setInterfaces(ICar.class, InvocationHandler.class);
        proxyFactory.setTarget(new Bus());

        proxyFactory.setAdvice(new MethodAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("afterReturning...");
            }

            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before...");
            }
        });

        ICar proxy = proxyFactory.getProxy();

        proxy.start();
        proxy.run();
        proxy.stop();
    }

}
