/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Reference
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.bean;

import com.john.soa.invoke.HttpInvoke;
import com.john.soa.invoke.Invoke;
import com.john.soa.proxy.advice.InvokeInvocationHandler;
import com.john.soa.util.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

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
    // 调用方式
    private Invoke invoke;

    private static Map<String, Invoke> invokeMap = new HashMap<>();

    // 多个生产者的服务列表
    // private List<String> registList;

    // 策略模式
    static {
        // TODO 注册 Http, Rim, Netty 三种调用方式
        invokeMap.put("http", new HttpInvoke());
        invokeMap.put("rmi", null);
        invokeMap.put("netty", null);
    }


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

    /**
     * ApplicationContext.getBean() 方法最终会调到 getObject 方法中来
     * getObject 方法的返回值会交给 Spring 容器进行管理
     * 在这个类中实现 FactoryBean 接口是因为 Reference 标签中有 interface 的定义
     * 方法中会生成 interface 接口的代理实例
     * 而且消费者可以根据代理实例进行 RPC 的远程调用
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        // TODO 创建 inf 的代理对象

        if(StringUtils.isNotEmpty(this.protocol)) {
            // 如果在 Reference 标签中定义了 protocol 就使用这个
            this.invoke = invokeMap.get(this.protocol);
        } else {
            // 否则以 Protocol 标签中的定义为准
            // 为了获取到 Protocol 的实例所以需要持有一个 Spring 的上下文
            // 获取上下文需要实现 ApplicationContextAware 接口
            Protocol pt = application.getBean(Protocol.class);
            if(null != pt) {
                invoke = invokeMap.get(pt.getName());
            } else {
                // 默认使用 http 协议
                invoke = invokeMap.get("http");
            }
        }
        // 创建代理实例需要 1.类加载器, 2.接口列表, 3.InvocationHandler 接口实现
        return Proxy.newProxyInstance(this.getClass().getClassLoader()
            , new Class<?>[] { Class.forName(this.inf) }
            , new InvokeInvocationHandler(this.invoke, this));
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
