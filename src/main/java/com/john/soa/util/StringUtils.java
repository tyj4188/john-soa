/*
 *
 * 项目名：	com.john.soa.util
 * 文件名：	StringUtils
 * 模块说明：
 * 修改历史：
 * 2018/4/12 - JOHN - 创建。
 */

package com.john.soa.util;

/**
 * @author JOHN
 * @date 2018/4/12
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
