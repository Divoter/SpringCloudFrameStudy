package com.divoter.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @ClassName CommonUtil
 * @Description
 * @Authour Divoter
 * @Date 2020/9/17 14:29
 * @Version 1.0
 */
public class CommonUtil {
    public static boolean isEmpty(Object o){
        return true;
    }

    public static boolean isNotEmpty(Object o){
        return true;
    }
    public static boolean isBlank(Object obj){
        if (obj == null) {
            return true;
        } else if (obj instanceof CharSequence) {
            return ((CharSequence)obj).length() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Collection) {
            return ((Collection)obj).isEmpty();
        } else {
            return obj instanceof Map ? ((Map)obj).isEmpty() : false;
        }
    }

    public static boolean isNotBlank(Object o){
        return !isBlank(o);
    }
}
