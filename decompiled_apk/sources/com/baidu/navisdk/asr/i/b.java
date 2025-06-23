package com.baidu.navisdk.asr.i;

import androidx.annotation.CallSuper;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    boolean f6550a;

    public abstract void a();

    @CallSuper
    public void a(String str, int i) {
        this.f6550a = true;
    }

    public boolean b() {
        return this.f6550a;
    }

    public abstract void c();
}
