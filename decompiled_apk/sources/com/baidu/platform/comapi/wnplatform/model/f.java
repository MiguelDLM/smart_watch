package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static f f9941a;
    private a b;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, int i2, int i3, Bundle bundle);
    }

    public static f a() {
        if (f9941a == null) {
            synchronized (f.class) {
                try {
                    if (f9941a == null) {
                        f9941a = new f();
                    }
                } finally {
                }
            }
        }
        return f9941a;
    }

    public void a(int i, int i2, int i3, Bundle bundle) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(i, i2, i3, bundle);
        }
    }
}
