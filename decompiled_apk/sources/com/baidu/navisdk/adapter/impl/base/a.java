package com.baidu.navisdk.adapter.impl.base;

import android.os.Bundle;

/* loaded from: classes7.dex */
public enum a {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0159a f6491a;

    /* renamed from: com.baidu.navisdk.adapter.impl.base.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0159a {
        void a(int i, int i2, int i3, Bundle bundle);
    }

    public void a(InterfaceC0159a interfaceC0159a) {
        this.f6491a = interfaceC0159a;
    }

    public void a(int i, int i2, int i3, Bundle bundle) {
        InterfaceC0159a interfaceC0159a = this.f6491a;
        if (interfaceC0159a != null) {
            interfaceC0159a.a(i, i2, i3, bundle);
        }
    }
}
