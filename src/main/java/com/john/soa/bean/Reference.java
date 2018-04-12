/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Reference
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.bean;

import com.john.soa.util.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class Reference extends BaseBean implements InitializingBean
    , ApplicationContextAware, FactoryBean {
    private static final long serialVersionUID = 1813185448513185L;

    // interface 接口
    private String inf;
    // 负载均衡
    private String loadbalance;
    // 协议
    private String protocol;

    // 多个生产者的服务列表
    private List<String> registList;


    // 持有 spring 上下文
    private static ApplicationContext application;

    public static ApplicationContext getApplication() {
        return application;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO 从注册中心获取服务列表(一个服务有可能会有多个生产者)
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Reference.application = applicationContext;
    }

    // 实现 FactoryBean 会最终会调用 getObject 方法返回方法内创建的对象
    @Override
    public Object getObject() throws Exception {
        // TODO 创建 inf 的代理对象

        return Proxy.newProxyInstance(this.getClass().getClassLoader()
            , new Class<?>[] { Class.forName(this.inf) }
            , new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return null;
                }
            });
    }

    @Override
    public Class<?> getObjectType() {
        try {
            if(StringUtils.isNotEmpty(this.inf)) {
                return Class.forName(this.inf);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        this.loadbalance = loadbalance;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

}
