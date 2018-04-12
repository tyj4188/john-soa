/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Protocol
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.bean;

import org.springframework.context.ApplicationContext;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class Protocol extends BaseBean {

    private static final long serialVersionUID = 6448463181318L;

    // 协议名称
    private String name;

    private String host;

    private String port;
    // 请求路径
    private String contextpath;

    // 持有 spring 上下文
    private static ApplicationContext application;


    public static ApplicationContext getApplication() {
        return application;
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
