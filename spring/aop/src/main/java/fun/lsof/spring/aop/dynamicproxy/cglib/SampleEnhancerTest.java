package fun.lsof.spring.aop.dynamicproxy.cglib;

import fun.lsof.spring.aop.common.Chrome;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class SampleEnhancerTest {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ArrayList.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //
                System.out.println("call method: " + method.getName());
                return methodProxy.invokeSuper(o, objects);
            }
        });
        ArrayList o = (ArrayList) enhancer.create();
        o.clear();
    }

}
