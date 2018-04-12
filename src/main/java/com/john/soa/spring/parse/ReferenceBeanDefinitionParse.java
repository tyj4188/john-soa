/*
 *
 * 项目名：	com.john.soa.spring.parse
 * 文件名：	ReferenceBeanDefinitionParse
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
 * Reference 标签解析
 * @author JOHN
 * @date 2018/4/12
 */
public class ReferenceBeanDefinitionParse implements BeanDefinitionParser {

    // 需要初始化的类Class对象
    private Class<?> beanClass;

    public ReferenceBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    /**
     *
     * @param element xml 元素
     * @param parserContext 上下文, 用于注册解析的类
     * @return
     */
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        // 设置类对象和加载类型
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        // 获取配置信息
        String id = element.getAttribute("id");
        String inf = element.getAttribute("interface");
        String loadbalance = element.getAttribute("loadbalance");
        String protocol = element.getAttribute("protocol");

        // 参数判断
        if(StringUtils.isEmpty(id)) {
            throw new RuntimeException("Reference id 不能为空！");
        }
        if(StringUtils.isEmpty(inf)) {
            throw new RuntimeException("Reference interface 不能为空！");
        }
        if(StringUtils.isEmpty(loadbalance)) {
            throw new RuntimeException("Reference loadbalance 不能为空！");
        }
        if(StringUtils.isEmpty(protocol)) {
            throw new RuntimeException("Reference protocol 不能为空！");
        }

        // 设置成员变量
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("inf", inf);
        beanDefinition.getPropertyValues().addPropertyValue("loadbalance", loadbalance);
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        // 注册
        parserContext.getRegistry().registerBeanDefinition("Reference-" + id, beanDefinition);
        return beanDefinition;
    }
}
