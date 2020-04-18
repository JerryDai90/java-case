package fun.lsof.spring.ioc.simulation.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

}
