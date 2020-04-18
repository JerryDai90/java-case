package fun.lsof.spring.ioc.simulation.test;

import fun.lsof.spring.ioc.simulation.annotation.Autowired;
import fun.lsof.spring.ioc.simulation.annotation.Component;

@Component
public class D {

    @Autowired
    C c1;

    @Autowired
    public D(A a, B b, C c){
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }

    public void say(){
        System.out.println("class: "+this.toString());
        System.out.println("C1："+c1.toString());
    }
}
