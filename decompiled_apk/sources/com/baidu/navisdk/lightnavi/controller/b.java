package com.baidu.navisdk.lightnavi.controller;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;

/* loaded from: classes7.dex */
public class b {
    private static volatile b b;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f6877a = false;

    private b() {
    }

    public static b c() {
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

    public boolean a() {
        return this.f6877a;
    }

    public void b() {
        this.f6877a = false;
    }

    public void a(boolean z) {
        this.f6877a = z;
    }

    public int a(int i) {
        return BNRouteGuider.getInstance().naviSwitchingCalcRoute(i);
    }
}
