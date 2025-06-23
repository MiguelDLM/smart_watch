package com.qq.e.comm.util;

import OoOoXO0.xoXoI;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Boolean> f19456a = new HashMap();

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }

    private static boolean a(Class cls, String str, Class... clsArr) {
        String sb;
        if (cls == null) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(xoXoI.f2670oxoX);
            sb2.append(str);
            for (Class cls2 : clsArr) {
                sb2.append("_");
                sb2.append(cls2.getName());
            }
            sb = sb2.toString();
        }
        Map<String, Boolean> map = f19456a;
        Boolean bool = map.get(sb);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(sb, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            f19456a.put(sb, Boolean.FALSE);
            return false;
        }
    }
}
