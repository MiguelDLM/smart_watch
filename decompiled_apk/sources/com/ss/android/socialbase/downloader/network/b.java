package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes13.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f26407a = false;
    private static final String b = "b";
    private static long g = -1;
    private static volatile b h;
    private final k c = k.a();
    private final AtomicInteger d = new AtomicInteger();
    private final a e = new a(com.ss.android.socialbase.downloader.h.e.a());
    private long f;

    /* loaded from: classes13.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                b.this.f();
                sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                try {
                    if (h == null) {
                        h = new b();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f26407a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.O());
    }

    public void b() {
        try {
            com.ss.android.socialbase.downloader.c.a.c(b, "startSampling: mSamplingCounter = " + this.d);
            if (this.d.getAndIncrement() == 0) {
                this.e.a();
                this.f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            com.ss.android.socialbase.downloader.c.a.c(b, "stopSampling: mSamplingCounter = " + this.d);
            if (this.d.decrementAndGet() == 0) {
                this.e.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f26407a) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = g;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.c.a(j2, uptimeMillis - this.f);
                    this.f = uptimeMillis;
                }
            }
            g = mobileRxBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g() {
        f();
        g = -1L;
    }
}
