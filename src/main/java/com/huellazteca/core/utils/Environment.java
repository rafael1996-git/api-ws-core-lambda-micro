package com.huellazteca.core.utils;

import com.huellazteca.core.exceptions.EnvironmentException;

;

public class Environment {
    public static String get(String name) throws EnvironmentException {
        String env = System.getenv(name);

        if (env == null)
            throw new EnvironmentException("Missing environment variable [" + name + "]. please define it before using");

        return env;
    }
}
