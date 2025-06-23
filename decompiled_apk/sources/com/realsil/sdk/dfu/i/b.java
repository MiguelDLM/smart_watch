package com.realsil.sdk.dfu.i;

import com.realsil.sdk.core.logger.ZLogger;

/* loaded from: classes11.dex */
public class b {
    public static boolean d = false;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f19541a = -1;
    public int b;
    public boolean c;

    public b(boolean z, int i) {
        this.c = z;
        this.b = i * 50000000;
    }

    public void a() {
        if (!this.c) {
            return;
        }
        if (this.f19541a == -1 || this.b == -1) {
            if (d) {
                ZLogger.d("flow control block with error, must initial first");
                return;
            }
            return;
        }
        do {
        } while (System.nanoTime() - this.f19541a < this.b);
        if (d) {
            ZLogger.v("flow control stopped");
        }
    }

    public void b() {
        if (!this.c) {
            return;
        }
        this.f19541a = System.nanoTime();
        if (d) {
            ZLogger.v("flow control started");
        }
    }
}
