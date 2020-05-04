package fun.lsof.spring.xml;

import fun.lsof.spring.xml.vo.Config;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomXmlDefinitionParserTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");

        Config bean = context.getBean(Config.class);

        System.out.println(bean);
    }

}
