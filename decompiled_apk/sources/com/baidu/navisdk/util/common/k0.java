package com.baidu.navisdk.util.common;

import android.os.SystemClock;

/* loaded from: classes8.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private long f9237a = SystemClock.elapsedRealtime();
    private long b;

    public long a() {
        return this.b - this.f9237a;
    }

    public void b() {
        this.f9237a = SystemClock.elapsedRealtime();
        LogUtil.e("Stopwatch", "stat test start time = " + this.f9237a);
    }

    public void c() {
        this.b = SystemClock.elapsedRealtime();
        LogUtil.e("Stopwatch", "stat test stop time = " + this.b);
    }

    public String toString() {
        return (SystemClock.elapsedRealtime() - this.f9237a) + " ms";
    }
}
