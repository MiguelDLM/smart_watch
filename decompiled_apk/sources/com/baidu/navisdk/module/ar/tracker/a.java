package com.baidu.navisdk.module.ar.tracker;

import android.graphics.Bitmap;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Object f6996a = new Object();
    Bitmap b = null;
    int c = 0;
    long d;

    public int a() {
        int i;
        synchronized (this.f6996a) {
            i = this.c + 1;
            this.c = i;
        }
        return i;
    }

    public Bitmap b() {
        return this.b;
    }

    public long c() {
        return this.d;
    }

    public int d() {
        int i;
        synchronized (this.f6996a) {
            try {
                int i2 = this.c;
                if (i2 != 0) {
                    this.c = i2 - 1;
                }
                i = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public void a(long j) {
        this.d = j;
    }
}
