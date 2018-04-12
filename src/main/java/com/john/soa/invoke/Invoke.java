/* 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * 
 * 项目名：	com.john.soa.invoke
 * 文件名：	Invoke
 * 模块说明：	
 * 修改历史：
 * 2018/4/12 - Tyj - 创建。
 */

package com.john.soa.invoke;


/**
 * 这个接口定义了远程 RPC 调用的规范
 * 采用策略模式需要一个顶层接口定义
 * @author Tyj
 * @date 2018/4/12
 */
public interface Invoke {
    /**
     * 返回 String 类型, 使用 Json 类型通信
     * @param invocation
     * @return
     */
    public String invoke(Invocation invocation);
}
