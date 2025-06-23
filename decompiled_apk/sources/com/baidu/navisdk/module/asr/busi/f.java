package com.baidu.navisdk.module.asr.busi;

/* loaded from: classes7.dex */
public class f {
    private static f c;

    /* renamed from: a, reason: collision with root package name */
    private String f7033a = null;
    private boolean b = false;

    private f() {
    }

    public static f c() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    public String a() {
        return this.f7033a;
    }

    public boolean b() {
        return this.b;
    }

    public void a(String str) {
        this.f7033a = str;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
