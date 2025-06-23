package com.adp.sdk.utils;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
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
            for (Method method : Class.forName(str).getDeclaredMethods()) {
                if (method.getName().equals(str2)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
