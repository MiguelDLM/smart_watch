package com.baidu.navisdk.skyeye;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.framework.message.b {
    private static b c;

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                c = new b();
            }
        }
        return c;
    }
}
