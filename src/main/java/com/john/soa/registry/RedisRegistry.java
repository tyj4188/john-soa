/*
 *
 * 项目名：	com.john.soa.registry
 * 文件名：	RedisRegistry
 * 模块说明：
 * 修改历史：
 * 2018/4/13 - JOHN - 创建。
 */

package com.john.soa.registry;

import com.alibaba.fastjson.JSONObject;
import com.john.soa.bean.Protocol;
import com.john.soa.bean.Registry;
import com.john.soa.bean.Service;
import com.john.soa.util.RedisUtils;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author JOHN
 * @date 2018/4/13
 */
public class RedisRegistry implements BaseRegistry {
    @Override
    public boolean registry(String ref, ApplicationContext application) {
        try {
            // 获取协议类型和 host:port
            Protocol protocol = application.getBean(Protocol.class);
            // 获取需要注册的服务信息
            Map<String, Service> serviceMap = application.getBeansOfType(Service.class);
            // 获取注册中心的信息
            Registry registry = application.getBean(Registry.class);

            RedisUtils.createJedisPool(registry.getAddress());

            for(Map.Entry<String, Service> entry : serviceMap.entrySet()) {
                // 每个服务只负责注册自己
                if(ref.equals(entry.getValue().getRef())) {
                    // 协议和服务信息
                    JSONObject jo = new JSONObject();
                    jo.put("protocol", protocol);
                    jo.put("service", entry.getValue());
                    // 暴露的IP和Port
                    JSONObject addr = new JSONObject();
                    // {"ip:port" : {"protocol" : protocol, "service" : service}}
                    addr.put(protocol.getHost() + ":" + protocol.getPort(), jo);

                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<String> getRegistry(String id, ApplicationContext application) {
        return null;
    }

    /**
     * 往 redis 中注册
     * @param key
     * @param param
     */
    private void lpush(String key, JSONObject param) {
        // 一个服务多次注册
        if(RedisUtils.exists(key)) {
            Set<String> keys = param.keySet();
            String addr = "";
            for(String tmp : keys) {
                // 循环只执行一次, 为了不写 get("xxxx")
                // 这里获取出来的就是 ip:port
                addr = tmp;
            }
        }


        // 机器重启
    }
}
