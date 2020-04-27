package fun.lsof.javacore.proxy.dynamic.aop;

import java.lang.reflect.Method;

public interface MethodAdvice {

    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;

    void before(Method method, Object[] args, Object target) throws Throwable;
}
