package com.baidu.mshield.x0.b.a;

import com.baidu.mshield.x0.EngineImpl;
import java.io.File;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f6402a = null;
    public static int b = Integer.MAX_VALUE;
    public static long c = 120;
    public ThreadPoolExecutor d;

    public d() {
        int i;
        int c2 = (c() / 2) + 2;
        if (c2 > 5) {
            i = 5;
        } else {
            i = c2;
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, b, c, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.d = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new c());
    }

    public static d a() {
        synchronized (d.class) {
            try {
                if (f6402a == null) {
                    f6402a = new d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6402a;
    }

    public void b() {
        try {
            this.d.shutdownNow();
            f6402a = null;
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new e(this)).length;
        } catch (Throwable unused) {
            return 2;
        }
    }

    public void a(a aVar) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            this.d.execute(aVar);
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }
}
