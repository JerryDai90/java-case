package fun.lsof.spring.xml;

import fun.lsof.spring.xml.vo.Config;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomXmlDefinitionParserTest {

    @Test
    public void test() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");

        Config bean = context.getBean(Config.class);

        System.out.println(bean);
    }
}
