package com.bytedance.pangle.b.a;

import OoOoXO0.xoXoI;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Field> f10517a = new HashMap();
    private static Map<String, Method> b = new HashMap();
    private static Map<String, Constructor> c = new HashMap();
    private static Map<String, Class> d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String b2 = b(cls, str, clsArr);
        synchronized (b) {
            method = b.get(b2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method a2 = b.a(cls, str, clsArr);
            if (a2 != null) {
                synchronized (b) {
                    b.put(b2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append(xoXoI.f2670oxoX);
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append(xoXoI.f2670oxoX);
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String b2 = b(cls, "clinit", clsArr);
        synchronized (c) {
            constructor = c.get(b2);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor a2 = b.a(cls, clsArr);
            if (a2 != null) {
                synchronized (c) {
                    c.put(b2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + xoXoI.f2670oxoX + str;
        synchronized (f10517a) {
            field = f10517a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field a2 = b.a(cls, str);
            if (a2 != null) {
                synchronized (f10517a) {
                    f10517a.put(str2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
