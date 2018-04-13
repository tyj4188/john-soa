/*
 *
 * 项目名：	com.john.soa.registry
 * 文件名：	RegisterDelegate
 * 模块说明：
 * 修改历史：
 * 2018/4/13 - JOHN - 创建。
 */

package com.john.soa.registry;

import com.john.soa.bean.Registry;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 注册入口, 用于选择注册方式进行注册
 * @author JOHN
 * @date 2018/4/13
 */
public class RegisterDelegate {
    /**
     * 往注册中心中注册
     * @param param
     * @param application
     * @return
     */
    public static boolean registry(String param, ApplicationContext application) {
        return get(application).registry(param, application);
    }

    /**
     * 从注册中心根据 ID 获取服务注册信息
     * @param id
     * @param application
     * @return
     */
    public static List<String> getRegistry(String id, ApplicationContext application) {
        return get(application).getRegistry(id, application);
    }

    /**
     * 获取注册中心的实现类
     * @param application
     * @return
     */
    private static BaseRegistry get(ApplicationContext application) {
        BaseRegistry rg = null;
        // 从容器中获取配的用户信息
        Registry registry = application.getBean(Registry.class);
        if(null != registry) {
            rg = registry.getRegistryMap().get(registry.getProtocol());
        }
        return rg;
    }
}
