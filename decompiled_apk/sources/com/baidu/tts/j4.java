package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class j4 {
    public static final String h = "j4";

    /* renamed from: a, reason: collision with root package name */
    public y3 f10116a;
    public WeakReference<j4> b;
    public l4 c;
    public String f;
    public int d = 0;
    public String e = null;
    public volatile boolean g = true;

    public j4(e0 e0Var, y3 y3Var, String str) {
        this.f10116a = null;
        this.b = null;
        this.c = null;
        this.f = null;
        this.f10116a = y3Var;
        this.b = new WeakReference<>(this);
        this.c = new l4();
        this.c.a(e0Var.d(), "1".equals(e0Var.d()) || "2".equals(e0Var.d()));
        this.c.a(e0Var.b(), e0Var.c());
        String e = e0Var.e();
        this.c.f10131a = (e == null || e.isEmpty()) ? z2.TTS_SERVER_WSS.a() : e;
        this.f = str;
    }

    public TtsError a(byte[] bArr) {
        p4 a2 = p4.a();
        WeakReference<j4> weakReference = this.b;
        j4 b = a2.b(a2.f10150a);
        synchronized (a2) {
            try {
                if (b == weakReference.get()) {
                    a2.f10150a.a(bArr);
                    return null;
                }
                return null;
            } finally {
            }
        }
    }
}
