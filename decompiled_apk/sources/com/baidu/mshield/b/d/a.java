package com.baidu.mshield.b.d;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public b f6368a;
    public Context b;

    public a(Context context, Handler handler) {
        try {
            this.b = context;
            this.f6368a = new b(context, handler);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    public String a() {
        return this.f6368a.a();
    }

    public String a(String str, byte[] bArr) throws Throwable {
        if (str != null) {
            return !com.baidu.mshield.b.e.a.c(this.b) ? "" : this.f6368a.a(str, bArr);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
