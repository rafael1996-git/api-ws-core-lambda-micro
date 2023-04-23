package com.huellazteca.core.utils;

import java.util.List;

public class Validator {
    public static boolean isNullOrEmptyString(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNullOrEmptyArray(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmptyList(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEqual(Object obj, Object value) {
        return (obj == null && value == null) || (obj != null && obj.equals(value));
    }
}
