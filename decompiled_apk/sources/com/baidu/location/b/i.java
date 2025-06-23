package com.baidu.location.b;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Object f5642a = new Object();
    private static i b;
    private int c = -1;

    public static i a() {
        i iVar;
        synchronized (f5642a) {
            try {
                if (b == null) {
                    b = new i();
                }
                iVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.c) {
            this.c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            c.a().a(bundle, 303);
        }
    }
}
