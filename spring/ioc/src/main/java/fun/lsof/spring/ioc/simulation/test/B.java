package fun.lsof.spring.ioc.simulation.test;


import fun.lsof.spring.ioc.simulation.annotation.Autowired;

public class B {

    @Autowired
    C c;

    public void say() {
        System.out.println("class: " + this.toString());
    }

}
