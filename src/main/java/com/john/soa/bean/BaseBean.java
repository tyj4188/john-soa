/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	BaseBean
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.bean;

import java.io.Serializable;

/**
 * 基本类, 用于实现序列化接口
 * @author JOHN
 * @date 2018/4/12
 */
public class BaseBean implements Serializable {
    private static final long serialVersionUID = 1161811321832184L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
