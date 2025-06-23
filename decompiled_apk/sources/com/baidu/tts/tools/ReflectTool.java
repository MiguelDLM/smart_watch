package com.baidu.tts.tools;

import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class ReflectTool {
    public static Method getSupportedMethod(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        if (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                return getSupportedMethod(cls.getSuperclass(), str, clsArr);
            }
        }
        throw new NoSuchMethodException();
    }
}
