/*
 *
 * 项目名：	com.john.soa.bean
 * 文件名：	NodeInfo
 * 模块说明：
 * 修改历史：
 * 2018/4/13 - JOHN - 创建。
 */

package com.john.soa.bean;

/**
 * 封装节点信息, 需要有节点的host:port/contextpath
 * @author JOHN
 * @date 2018/4/13
 */
public class NodeInfo {

    private String host;

    private String port;

    private String contextpath;

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
