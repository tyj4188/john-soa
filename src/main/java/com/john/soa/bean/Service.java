/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Service
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
public class Service extends BaseBean implements InitializingBean, ApplicationContextAware {
    private static final long serialVersionUID = 8421831843486L;

    // 接口
    private String inf;
    // 引用
    private String ref;
    // 协议
    private String protocol;

    // 持有 spring 上下文
    private static ApplicationContext application;

    public static ApplicationContext getApplication() {
        return application;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO 往注册中心注册服务
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Service.application = applicationContext;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

}
