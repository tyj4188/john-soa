/* 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * 
 * 项目名：	com.john.soa.invoke
 * 文件名：	Invocation
 * 模块说明：	
 * 修改历史：
 * 2018/4/12 - Tyj - 创建。
 */

package com.john.soa.invoke;

import java.lang.reflect.Method;

/**
 * 这个对象封装的是代理类的一些参数
 * 封装的就是 InvokeInvocationHandler 调用时所需要的参数
 * @author Tyj
 * @date 2018/4/12
 */
public class Invocation {
    private Method method;

    private Object[] objs;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getObjs() {
        return objs;
    }

    public void setObjs(Object[] objs) {
        this.objs = objs;
    }
}
