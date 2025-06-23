package com.baidu.mshield.x6.e.a;

import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.e.f;
import java.io.File;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static c f6444a = null;
    public static int b = Integer.MAX_VALUE;
    public static long c = 120;
    public ThreadPoolExecutor d;

    public c() {
        int i;
        int c2 = (c() / 2) + 2;
        if (c2 > 5) {
            i = 5;
        } else {
            i = c2;
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, b, c, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.d = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new b());
    }

    public static c a() {
        synchronized (c.class) {
            try {
                if (f6444a == null) {
                    f6444a = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6444a;
    }

    public void b() {
        try {
            this.d.shutdownNow();
            f6444a = null;
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new d(this)).length;
        } catch (Throwable th) {
            f.a(th);
            return 2;
        }
    }

    public void a(e eVar) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            this.d.execute(eVar);
        } catch (Throwable th) {
            f.a(th);
        }
    }
}
