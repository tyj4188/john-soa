/*
 *
 * 项目名：	com.john.soa.spring.parse
 * 文件名：	SOANamespaceHandler
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.spring.parse;

import com.john.soa.bean.Protocol;
import com.john.soa.bean.Reference;
import com.john.soa.bean.Registry;
import com.john.soa.bean.Service;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class SOANamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("protocol", new ProtocolBeanDefinitionParse(Protocol.class));
        registerBeanDefinitionParser("reference", new ReferenceBeanDefinitionParse(Reference.class));
        registerBeanDefinitionParser("registry", new RegistryBeanDefinitionParse(Registry.class));
        registerBeanDefinitionParser("service", new ServiceBeanDefinitionParse(Service.class));
    }
}
