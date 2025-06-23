package com.baidu.mshield.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6391a = new e();
    public HandlerThread b = new HandlerThread("rp_th", 10);
    public Handler c;

    public e() {
        b();
        this.c = new Handler(this.b.getLooper());
    }

    public static Looper a() {
        return f6391a.c.getLooper();
    }

    public final void b() {
        this.b.start();
    }
}
