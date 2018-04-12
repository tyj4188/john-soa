/*
 *
 * 项目名：	com.john.soa.spring.parse
 * 文件名：	ServiceBeanDefinitionParse
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.spring.parse;

import com.john.soa.util.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class ServiceBeanDefinitionParse implements BeanDefinitionParser {
    private Class<?> beanClass;

    public ServiceBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        String inf = element.getAttribute("interface");
        String ref = element.getAttribute("ref");
        String protocol = element.getAttribute("protocol");

        // 参数判断
        if(StringUtils.isEmpty(inf)) {
            throw new RuntimeException("Service interface 不能为空！");
        }
        if(StringUtils.isEmpty(ref)) {
            throw new RuntimeException("Service ref 不能为空！");
        }
        if(StringUtils.isEmpty(protocol)) {
            throw new RuntimeException("Service protocol 不能为空！");
        }

        beanDefinition.getPropertyValues().addPropertyValue("inf", inf);
        beanDefinition.getPropertyValues().addPropertyValue("ref", ref);
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);

        parserContext.getRegistry().registerBeanDefinition("Service" + ref, beanDefinition);

        return beanDefinition;
    }
}
