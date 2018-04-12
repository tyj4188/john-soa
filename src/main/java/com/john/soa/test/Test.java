/*
 *
 * 项目名：	com.john.soa.test
 * 文件名：	Test
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.test;

import com.john.soa.test.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mytest.xml");
        TestService testService = context.getBean(TestService.class);
        testService.eat("apple");
    }
}
