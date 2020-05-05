package fun.lsof.spring.xml;

import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 命名空间解析注册.
 *
 * @author jerry
 * @date 2020 -05-04 21:40:38
 */
public class ConfigNamespaceHandlerSupport extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("config", new ConfigDefinitionParser());
    }

}
