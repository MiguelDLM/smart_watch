package com.baidu.navisdk.model;

/* loaded from: classes7.dex */
public class b {
    private static volatile b b;

    /* renamed from: a, reason: collision with root package name */
    public int f6901a = 0;

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public int a() {
        return this.f6901a;
    }
}
