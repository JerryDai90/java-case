package fun.lsof.spring.xml;

import fun.lsof.spring.xml.vo.Config;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class ConfigDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private String getAttribute(Element element, String attr) {
        if (element.hasAttribute(attr)) {
            return element.getAttribute(attr);
        }
        return null;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        builder.addPropertyValue("ip", getAttribute(element, "ip"));
        builder.addPropertyValue("port", getAttribute(element, "port"));
        builder.addPropertyValue("path", getAttribute(element, "path"));

    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Config.class;
    }
}
