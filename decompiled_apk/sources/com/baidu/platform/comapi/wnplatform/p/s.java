package com.baidu.platform.comapi.wnplatform.p;

import com.baidu.platform.comapi.wnplatform.p.g;

/* loaded from: classes8.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static s f9968a;
    private int b;
    private int c;
    private String d;
    private String e;

    private s() {
    }

    public static synchronized s a() {
        s sVar;
        synchronized (s.class) {
            try {
                if (f9968a == null) {
                    f9968a = new s();
                }
                sVar = f9968a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public void d() {
        this.e = "";
        this.d = "";
    }

    public void a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.b = i;
        this.c = i2;
        StringBuffer stringBuffer = new StringBuffer();
        g.a(i2, g.b.ZH, stringBuffer);
        this.e = stringBuffer.toString();
        this.d = g.a(i, 2);
    }
}
