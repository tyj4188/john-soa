/* 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * 
 * 项目名：	com.john.soa.proxy.advice
 * 文件名：	InvokeInvocationHandler
 * 模块说明：	
 * 修改历史：
 * 2018/4/12 - Tyj - 创建。
 */

package com.john.soa.proxy.advice;

import com.john.soa.bean.Reference;
import com.john.soa.invoke.Invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvokeInvocationHandler 是一个 advice, 在这个里面进行 RPC 远程调用
 * RPC调用方式 : Http, Rmi, Netty
 * @author Tyj
 * @date 2018/4/12
 */
public class InvokeInvocationHandler implements InvocationHandler {

    // 这个是具体的调用方式
    private Invoke invoke;

    // reference 中有调用者所有的信息
    private Reference reference;

    // 这两个成员中包含实现 RPC 调用的所有必要参数
    public InvokeInvocationHandler(Invoke invoke, Reference reference) {
        this.invoke = invoke;
        this.reference = reference;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvokeInvocationHandler.invoke 测试, 调用成功 !");
        return null;
    }
}
