package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.resource.ResourceList;
import com.baidu.platform.comapi.resource.b;
import com.baidu.vi.VIContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class JNIInitializer {
    private static Context d;
    private static a e;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static boolean j;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f9531a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static final CountDownLatch f = new CountDownLatch(1);

    public static void attach(Application application, boolean z, boolean z2, boolean z3, boolean z4) {
        if (application != null) {
            g = z;
            h = z2;
            i = z3;
            j = z4;
            if (d == null) {
                d = application;
            }
            VIContext.init(application);
            return;
        }
        throw new RuntimeException("BDMapSDKException: Application Context is null");
    }

    public static void destroy() {
        e.b();
        f9531a.set(false);
    }

    public static Context getCachedContext() {
        return d;
    }

    public static CountDownLatch getResourceDoneLatch() {
        return f;
    }

    public static void initEngine() {
        while (true) {
            AtomicBoolean atomicBoolean = f9531a;
            boolean z = atomicBoolean.get();
            if (z) {
                return;
            }
            if (atomicBoolean.compareAndSet(z, true)) {
                a aVar = new a();
                e = aVar;
                if (!aVar.a(d)) {
                    throw new RuntimeException("BDMapSDKException: engine init failed");
                }
            }
        }
    }

    public static void initEngineResource(ResourceList resourceList) {
        while (true) {
            AtomicBoolean atomicBoolean = c;
            boolean z = atomicBoolean.get();
            if (z) {
                return;
            }
            if (atomicBoolean.compareAndSet(z, true)) {
                if (resourceList != null) {
                    try {
                        b.f9682a.a(resourceList);
                    } finally {
                        f.countDown();
                    }
                }
            }
        }
    }

    public static void initLongLink() {
        while (true) {
            AtomicBoolean atomicBoolean = b;
            boolean z = atomicBoolean.get();
            if (z) {
                return;
            }
            if (atomicBoolean.compareAndSet(z, true)) {
                a aVar = e;
                if (aVar != null) {
                    if (!aVar.b(d)) {
                        throw new RuntimeException("longlink init failed");
                    }
                } else {
                    throw new RuntimeException("engine must init first");
                }
            }
        }
    }

    public static boolean isBaseLineRelease() {
        return j;
    }

    public static boolean isDebug() {
        return h;
    }

    public static boolean isInited() {
        return f9531a.get();
    }

    public static boolean isMainProcess() {
        return g;
    }

    public static boolean isResourceInited() {
        return c.get();
    }

    public static boolean isUserTest() {
        return i;
    }
}
