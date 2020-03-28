package fun.lsof.spring.aop.config4xml.advice;

import org.springframework.aop.*;

import java.lang.reflect.Method;

public class MethodAdvice implements AfterReturningAdvice, MethodBeforeAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("-------afterReturning");
    }


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("-------before");

    }
}
