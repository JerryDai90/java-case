package fun.lsof.spring.ioc.simulation.test;


import fun.lsof.spring.ioc.simulation.support.AnnotationApplicationContext;

/**
 * 模拟写一个 IOC 简单的依赖注入.
 *
 * @author jerry
 * @date 2020 -03-28 16:04:39
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {

        A a = AnnotationApplicationContext.getBean(A.class);
        a.say();

        System.out.println("--------------------------------");

        new Thread(() -> {
            D d = AnnotationApplicationContext.getBean(D.class);
            d.say();
        }).start();


        Thread.sleep(100L);
        System.out.println("--------------------------------");

        new Thread(() -> {
            D d = AnnotationApplicationContext.getBean(D.class);
            d.say();
        }).start();

    }


}
