package com.baidu.mobads.sdk.internal;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f6265a;

    /* loaded from: classes7.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f6266a = "remote_adserv";
        public static final String b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f6265a == null) {
            synchronized (c.class) {
                try {
                    if (f6265a == null) {
                        f6265a = new c();
                    }
                } finally {
                }
            }
        }
        return f6265a;
    }

    public as a(String str) {
        return new as(str);
    }
}
