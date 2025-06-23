package com.baidu.navisdk.ui.routeguide.model;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f8931a;

    /* loaded from: classes8.dex */
    public enum a {
        AVOID_TRAFFIC,
        CLOUD_RECOMMEND
    }

    private c() {
        a aVar = a.AVOID_TRAFFIC;
    }

    public void a(boolean z) {
    }

    public void b(boolean z) {
    }

    public static c a() {
        if (f8931a == null) {
            f8931a = new c();
        }
        return f8931a;
    }
}
