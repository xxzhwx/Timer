package com.xxzhwx.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class SystemPropertyUtil {
    public static String get(final String key, String def) {
        if (key == null) {
            throw new NullPointerException("key");
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }

        String value;
        if (System.getSecurityManager() == null) {
            value = System.getProperty(key);
        } else {
            value = AccessController.doPrivileged((PrivilegedAction<String>) () -> System.getProperty(key));
        }

        if (value == null) {
            return def;
        }

        return value;
    }
}
