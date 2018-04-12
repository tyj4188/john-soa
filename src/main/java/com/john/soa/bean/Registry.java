/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Registry
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class Registry extends BaseBean implements InitializingBean, ApplicationContextAware {

    private static final long serialVersionUID = 28421811184631L;

    private String protocol;

    private String address;

    private static ApplicationContext application;

    public static ApplicationContext getApplication() {
        return application;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Registry.application = applicationContext;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
