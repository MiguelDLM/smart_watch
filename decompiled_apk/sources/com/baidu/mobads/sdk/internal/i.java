package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* loaded from: classes7.dex */
public abstract class i<T> implements Runnable {
    private static final String b = "BaseTask";
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static b j;

    /* renamed from: a, reason: collision with root package name */
    protected Future<T> f6328a;
    private String f;
    private long g;
    private long h;
    private long i;

    /* loaded from: classes7.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        final i f6329a;
        final T b;

        public a(i iVar, T t) {
            this.f6329a = iVar;
            this.b = t;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        aVar.f6329a.j();
                        return;
                    }
                    return;
                }
                aVar.f6329a.a((Throwable) aVar.b);
                return;
            }
            aVar.f6329a.a((i) aVar.b);
        }
    }

    public i() {
        this.f = "default";
    }

    private static Handler k() {
        b bVar;
        synchronized (i.class) {
            try {
                if (j == null) {
                    j = new b(Looper.getMainLooper());
                }
                bVar = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public void a(T t) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f6328a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f6328a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.h - this.g;
    }

    public long f() {
        return this.i - this.g;
    }

    public long g() {
        return this.i - this.h;
    }

    public i h() {
        try {
            this.h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public abstract T i();

    public void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Throwable th) {
    }

    public i(String str) {
        this.f = str;
    }

    public String a() {
        return this.f;
    }

    public void a(Future future) {
        this.f6328a = future;
    }

    public void a(long j2) {
        this.g = j2;
    }

    public void a(boolean z) {
        Future<T> future = this.f6328a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
