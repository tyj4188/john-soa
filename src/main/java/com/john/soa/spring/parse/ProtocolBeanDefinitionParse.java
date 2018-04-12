/*
 *
 * 项目名：	com.john.soa.spring.parse
 * 文件名：	ProtocolBeanDefinitionParse
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
 * Protocol 标签解析
 * @author JOHN
 * @date 2018/4/12
 */
public class ProtocolBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> beanClass;

    public ProtocolBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        // 初始化beanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        // 获取配置信息
        String name = element.getAttribute("name");
        String host = element.getAttribute("host");
        String port = element.getAttribute("port");
        String contextpath = element.getAttribute("contextpath");

        // 参数判断
        if(StringUtils.isEmpty(name)) {
            throw new RuntimeException("Protocol name 不能为空！");
        }
        if(StringUtils.isEmpty(host)) {
            throw new RuntimeException("Protocol host 不能为空！");
        }
        if(StringUtils.isEmpty(port)) {
            throw new RuntimeException("Protocol port 不能为空！");
        }

        // 设置成员变量
        beanDefinition.getPropertyValues().addPropertyValue("name", name);
        beanDefinition.getPropertyValues().addPropertyValue("host", host);
        beanDefinition.getPropertyValues().addPropertyValue("port", port);
        beanDefinition.getPropertyValues().addPropertyValue("contextpath", contextpath);

        // 注册
        parserContext.getRegistry().registerBeanDefinition("Protocol" + host + port, beanDefinition);

        return beanDefinition;
    }
}
