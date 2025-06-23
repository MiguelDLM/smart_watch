package com.baidu.navisdk.framework.data;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6805a;

    public b(String str, Object obj) {
        this.f6805a = obj;
    }

    public <T> T a() {
        T t = (T) this.f6805a;
        if (t == null) {
            return null;
        }
        return t;
    }

    public <T> T a(T t) {
        T t2 = (T) this.f6805a;
        return t2 == null ? t : t2;
    }
}
