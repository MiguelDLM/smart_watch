package com.baidu.navisdk.ui.util;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private long f9203a = 800;
    private long b;

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.b;
        if (0 < j && j < this.f9203a) {
            return true;
        }
        this.b = currentTimeMillis;
        return false;
    }
}
