package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.af;

/* loaded from: classes10.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17283a = "SafeRunnable";
    private Runnable b;

    public k(Runnable runnable) {
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.b;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                af.d(f17283a, "exception in task run: " + th.getClass().getSimpleName());
            }
        }
    }
}
