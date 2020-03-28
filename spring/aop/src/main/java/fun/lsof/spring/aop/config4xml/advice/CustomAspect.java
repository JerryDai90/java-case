package fun.lsof.spring.aop.config4xml.advice;

public class CustomAspect {

    public void before() {
        System.out.println("-------before");
    }

    public void after() {
        System.out.println("-------after");
    }

}
