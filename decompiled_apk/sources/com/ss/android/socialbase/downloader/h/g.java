package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes13.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private Object f26309a = new Object();
    private Queue<b> b = new ConcurrentLinkedQueue();
    private a c;
    private Handler d;

    /* loaded from: classes13.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.f26309a) {
                g.this.d = new Handler(looper);
            }
            while (!g.this.b.isEmpty()) {
                b bVar = (b) g.this.b.poll();
                if (bVar != null) {
                    g.this.d.postDelayed(bVar.f26311a, bVar.b);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f26311a;
        public long b;

        public b(Runnable runnable, long j) {
            this.f26311a = runnable;
            this.b = j;
        }
    }

    public g(String str) {
        this.c = new a(str);
    }

    public void b() {
        this.c.quit();
    }

    public void a() {
        this.c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j) {
        if (this.d == null) {
            synchronized (this.f26309a) {
                try {
                    if (this.d == null) {
                        this.b.add(new b(runnable, j));
                        return;
                    }
                } finally {
                }
            }
        }
        this.d.postDelayed(runnable, j);
    }
}
