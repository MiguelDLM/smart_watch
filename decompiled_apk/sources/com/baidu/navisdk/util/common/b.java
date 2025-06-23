package com.baidu.navisdk.util.common;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b {
    private static b b;

    /* renamed from: a, reason: collision with root package name */
    private int f9219a;

    private b() {
        new ArrayList();
        this.f9219a = 0;
    }

    public static b b() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public void a(int i) {
        this.f9219a = i;
    }

    public int a() {
        return this.f9219a;
    }
}
