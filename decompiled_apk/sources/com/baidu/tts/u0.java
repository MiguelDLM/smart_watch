package com.baidu.tts;

import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class u0 {
    public static boolean d = false;

    /* renamed from: a, reason: collision with root package name */
    public Method f10175a;
    public Method b;
    public Object c;

    public u0(long j) {
        try {
            Object newInstance = Class.forName("com.baidu.speech.PlayCache").getConstructor(Long.TYPE).newInstance(Long.valueOf(j));
            this.c = newInstance;
            Class<?> cls = newInstance.getClass();
            Class<?> cls2 = Integer.TYPE;
            this.f10175a = cls.getDeclaredMethod("write", new byte[0].getClass(), cls2, cls2);
            this.b = this.c.getClass().getDeclaredMethod("close", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        Method method = this.b;
        if (method == null && this.c == null) {
            return;
        }
        try {
            method.invoke(this.c, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(int i) {
        try {
            Class<?> cls = Class.forName("com.baidu.speech.spil.sdk.aec.AecManager");
            cls.getMethod("resetAEC", Integer.TYPE).invoke(cls.newInstance(), Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
