/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	Registry
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.bean;

import com.john.soa.registry.BaseRegistry;
import com.john.soa.registry.RedisRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class Registry extends BaseBean {

    // 注册中心
    private static Map<String, BaseRegistry> registryMap = new HashMap<>();

    private static final long serialVersionUID = 28421811184631L;

    private String protocol;

    private String address;

    static {
        // TODO 多个注册中心的实现方式
        registryMap.put("redis", new RedisRegistry());
    }

    public static Map<String, BaseRegistry> getRegistryMap() {
        return registryMap;
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
