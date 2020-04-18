package fun.lsof.spring.ioc.simulation.test;

import fun.lsof.spring.ioc.simulation.annotation.Autowired;
import fun.lsof.spring.ioc.simulation.annotation.Component;

@Component
public class A {

    @Autowired
    private B b;

    @Autowired
    private C c;

    public void say(){
        System.out.println(b.toString());
        System.out.println(c.toString());

        b.say();
        c.say();
    }
}
