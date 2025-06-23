package com.baidu.navisdk.asr.i;

import android.os.Bundle;
import androidx.annotation.CallSuper;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    boolean f6549a;

    public a() {
        new Bundle();
    }

    @CallSuper
    public void a(String str, boolean z) {
        this.f6549a = true;
    }

    public abstract void b();

    public boolean a() {
        return this.f6549a;
    }
}
