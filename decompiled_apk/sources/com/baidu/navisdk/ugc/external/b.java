package com.baidu.navisdk.ugc.external;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final long f8173a;
    private final long b;
    private long c;
    private boolean e;
    private boolean d = false;
    private Handler f = new a();

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (b.this) {
                try {
                    if (b.this.d) {
                        return;
                    }
                    long elapsedRealtime = b.this.c - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (elapsedRealtime <= 0) {
                        b.this.c();
                        b.this.e = true;
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        b.this.a(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < b.this.b) {
                            j = elapsedRealtime - elapsedRealtime3;
                            if (j < 0) {
                                sendMessageDelayed(obtainMessage(1), j2);
                            }
                        } else {
                            j = b.this.b - elapsedRealtime3;
                            while (j < 0) {
                                j += b.this.b;
                            }
                        }
                        j2 = j;
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public b(long j, long j2) {
        this.f8173a = j;
        this.b = j2;
    }

    public abstract void a(long j);

    public abstract void c();

    public final synchronized b d() {
        this.d = false;
        if (this.f8173a <= 0) {
            c();
            return this;
        }
        this.c = SystemClock.elapsedRealtime() + this.f8173a;
        Handler handler = this.f;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public boolean b() {
        return this.d;
    }

    public final synchronized void a() {
        this.d = true;
        this.f.removeMessages(1);
    }
}
