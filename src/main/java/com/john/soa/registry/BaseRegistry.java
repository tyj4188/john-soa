/*
 *
 * 项目名：	com.john.soa.registry
 * 文件名：	BaseRegistry
 * 模块说明：
 * 修改历史：
 * 2018/4/13 - JOHN - 创建。
 */

package com.john.soa.registry;

import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 注册的基本接口
 * @author JOHN
 * @date 2018/4/13
 */
public interface BaseRegistry {
    /**
     * 注册
     * @param ref
     * @param application
     * @return
     */
    public boolean registry(String ref, ApplicationContext application);

    /**
     * 获取注册信息, 一个服务会有多个生产者
     * @param id
     * @param application
     * @return
     */
    public List<String> getRegistry(String id, ApplicationContext application);
}
