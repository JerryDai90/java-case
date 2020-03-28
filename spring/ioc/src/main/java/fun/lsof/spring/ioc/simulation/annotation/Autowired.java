package fun.lsof.spring.ioc.simulation.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

}
