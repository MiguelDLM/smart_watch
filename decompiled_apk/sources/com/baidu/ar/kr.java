package com.baidu.ar;

import java.lang.reflect.Constructor;

/* loaded from: classes7.dex */
public class kr {
    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(a(str, clsArr), objArr);
        } catch (Exception unused) {
            kf.u("ReflectionUtils", "getNewInstance(params) className = " + str + " error!!!");
            return null;
        }
    }

    public static Object cq(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception unused) {
            kf.u("ReflectionUtils", "getNewInstance() className = " + str + " error!!!");
            return null;
        }
    }

    public static Object x(String str, String str2) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, null).invoke(null, null);
        } catch (Exception unused) {
            kf.u("ReflectionUtils", "getSingleInstance() className = " + str + " error!!!");
            return null;
        }
    }

    public static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            kf.u("ReflectionUtils", "getNewInstance() error!!!");
            return null;
        }
    }

    public static Constructor<?> a(String str, Class<?>... clsArr) {
        try {
            return Class.forName(str).getDeclaredConstructor(clsArr);
        } catch (Exception unused) {
            kf.u("ReflectionUtils", "getSingleInstance() className = " + str + " error!!!");
            return null;
        }
    }

    public static boolean a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader) != null;
        } catch (Exception unused) {
            kf.u("ReflectionUtils", "isClassExist() class " + str + " is not exist!!!");
            return false;
        }
    }
}
