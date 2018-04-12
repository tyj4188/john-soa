/*
 *
 * 项目名：	com.john.soa.spring.parse
 * 文件名：	RegistryBeanDefinitionParse
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
public class RegistryBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> beanClass;

    public RegistryBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        // 获取配置信息
        String protocol = element.getAttribute("protocol");
        String address = element.getAttribute("address");

        // 参数判断
        if(StringUtils.isEmpty(protocol)) {
            throw new RuntimeException("Registry protocol 不能为空！");
        }
        if(StringUtils.isEmpty(address)) {
            throw new RuntimeException("Registry address 不能为空！");
        }

        // 设置成员变量
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        beanDefinition.getPropertyValues().addPropertyValue("address", address);

        // 注册
        parserContext.getRegistry().registerBeanDefinition("Registry" + address, beanDefinition);

        return beanDefinition;
    }
}
