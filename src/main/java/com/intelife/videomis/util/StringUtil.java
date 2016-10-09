package com.intelife.videomis.util;

public class StringUtil {

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static Integer toInt(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return Integer.parseInt(str);
    }

    public static Character toChar(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return str.charAt(0);
    }

    public static Float toFloat(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return Float.parseFloat(str);
    }

    public static Long toLong(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return Long.parseLong(str);
    }

}
