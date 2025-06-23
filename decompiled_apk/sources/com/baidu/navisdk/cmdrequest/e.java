package com.baidu.navisdk.cmdrequest;

import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class e {
    private static e b;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Class<? extends a>> f6692a = new HashMap<>();

    private e() {
        b();
    }

    private static e a() {
        if (b == null) {
            b = new e();
        }
        return b;
    }

    private void b() {
        b(c.class);
    }

    private void b(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields == null) {
            return;
        }
        for (Field field : declaredFields) {
            try {
                Object obj = field.get(null);
                if (obj instanceof String) {
                    String str = (String) obj;
                    d dVar = (d) field.getAnnotation(d.class);
                    LogUtil.e("xxxxxx", dVar.toString() + dVar.annotationType().toString());
                    if (str != null) {
                        Class<? extends a> value = dVar.value();
                        if (value == null) {
                            LogUtil.e("", "Command mapping definition in CommandConstant is error:" + str);
                        } else {
                            this.f6692a.put(str, value);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static a a(i iVar) {
        a a2 = a().a(iVar.f6694a);
        return a2 == null ? a().a(iVar.b) : a2;
    }

    private a a(String str) {
        return a(this.f6692a.get(str));
    }

    private a a(Class<? extends a> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
