/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Protocol
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
public class Protocol extends BaseBean implements InitializingBean, ApplicationContextAware {

    private static final long serialVersionUID = 6448463181318L;

    // 协议名称
    private String name;

    private String host;

    private String port;
    // 请求路径
    private String contextpath;

    // 持有 spring 上下文
    private static ApplicationContext application;

    // 在初始化Bean的时候会调用该方法
    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO 这里需要初始化协议支持的服务
        // http
        // rmi
        // netty
    }

    public static ApplicationContext getApplication() {
        return application;
    }

    // 设置 spring 容器上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Protocol.application = applicationContext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getContextpath() {
        return contextpath;
    }

    public void setContextpath(String contextpath) {
        this.contextpath = contextpath;
    }

}
