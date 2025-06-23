package com.adp.sdk.utils;

import java.lang.reflect.Method;

public final class b {
    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            for (Method name : Class.forName(str).getDeclaredMethods()) {
                if (name.getName().equals(str2)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
