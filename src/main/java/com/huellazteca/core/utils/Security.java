package com.huellazteca.core.utils;

public class Security {
    private Security(){}
    public static String stringSQLInjectionCleaner(String dirtyString) {
        return dirtyString
                .replace("'", "")
                .replace(";", "")
                .replace("&", "")
                .replace("#", "")
                .replace("|", "");
    }
}
