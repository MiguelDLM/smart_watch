package com.baidu.navisdk.framework;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes7.dex */
public class a {
    private static volatile a c;

    /* renamed from: a, reason: collision with root package name */
    private Context f6798a = null;
    private InterfaceC0196a b;

    /* renamed from: com.baidu.navisdk.framework.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0196a {
        Activity a();
    }

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a(Context context) {
        this.f6798a = context;
    }

    public Activity b() {
        InterfaceC0196a interfaceC0196a = this.b;
        if (interfaceC0196a != null && interfaceC0196a.a() != null) {
            return this.b.a();
        }
        return null;
    }

    public Context a() {
        return this.f6798a;
    }
}
