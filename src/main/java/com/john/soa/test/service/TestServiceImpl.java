/*
 *
 * 项目名：	com.john.soa.test
 * 文件名：	TestServiceImpl
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.test.service;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class TestServiceImpl implements TestService {
    public String eat(String food) {
        System.out.println("TestServiceImpl.eat ---- " + food);
        return "Now Eating " + food;
    }
}
