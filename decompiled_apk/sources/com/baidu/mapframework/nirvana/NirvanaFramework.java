package com.baidu.mapframework.nirvana;

import com.baidu.mapframework.nirvana.looper.LooperBuffer;
import com.baidu.mapframework.nirvana.monitor.NirvanaMonitor;
import com.baidu.mapframework.nirvana.schedule.LifecycleManager;

/* loaded from: classes7.dex */
public class NirvanaFramework {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6073a = false;
    private static NirvanaExceptionHandler b;
    private static NirvanaMonitor c = new NirvanaMonitor(false);
    private static LooperBuffer d = new LooperBuffer(true);
    private static LifecycleManager e = new LifecycleManager();

    public static LifecycleManager getLifecycleManager() {
        return e;
    }

    public static LooperBuffer getLooperBuffer() {
        return d;
    }

    public static NirvanaMonitor getMonitor() {
        return c;
    }

    public static boolean isDebug() {
        return f6073a;
    }

    public static void onUncaughtException(String str, Exception exc) {
        NirvanaExceptionHandler nirvanaExceptionHandler = b;
        if (nirvanaExceptionHandler != null) {
            nirvanaExceptionHandler.onException(str, exc);
        }
    }

    public static void setDebug(boolean z) {
        f6073a = z;
    }

    public static void setExceptionHandler(NirvanaExceptionHandler nirvanaExceptionHandler) {
        b = nirvanaExceptionHandler;
    }
}
