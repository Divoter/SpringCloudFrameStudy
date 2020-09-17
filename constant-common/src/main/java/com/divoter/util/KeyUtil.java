package com.divoter.util;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description
 * @Authour Divoter
 * @Date 2020/9/17 11:34
 * @Version 1.0
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey(String key) {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return key+System.currentTimeMillis() + String.valueOf(number);
    }
}
