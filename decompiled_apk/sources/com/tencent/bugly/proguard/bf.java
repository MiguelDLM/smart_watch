package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes13.dex */
public final class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final Handler f26594a;
    long d;
    private final String e;
    private final List<ba> f = new LinkedList();
    long b = 5000;
    private final long g = 5000;
    boolean c = true;

    public bf(Handler handler, String str) {
        this.f26594a = handler;
        this.e = str;
    }

    private Thread e() {
        return this.f26594a.getLooper().getThread();
    }

    public final boolean a() {
        if (!this.c && SystemClock.uptimeMillis() >= this.d + this.b) {
            return true;
        }
        return false;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f) {
            try {
                arrayList = new ArrayList(this.f.size());
                for (int i = 0; i < this.f.size(); i++) {
                    ba baVar = this.f.get(i);
                    if (!baVar.e && currentTimeMillis - baVar.b < 200000) {
                        arrayList.add(baVar);
                        baVar.e = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
        } catch (SecurityException e) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e.getMessage());
            sb.append("\n");
            al.a(e);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f26589a = name;
        synchronized (this.f) {
            while (this.f.size() >= 32) {
                try {
                    this.f.remove(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f.add(baVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c = true;
        this.b = this.g;
    }
}
