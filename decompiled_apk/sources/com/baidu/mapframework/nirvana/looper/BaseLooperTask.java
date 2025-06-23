package com.baidu.mapframework.nirvana.looper;

import com.baidu.mapframework.nirvana.NirvanaTask;

/* loaded from: classes7.dex */
public abstract class BaseLooperTask extends NirvanaTask implements Runnable {
    private boolean c = false;
    private Runnable d = null;

    public synchronized void a(Runnable runnable) {
        this.d = runnable;
    }

    public synchronized void cancel() {
        this.c = true;
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized boolean isCancel() {
        return this.c;
    }
}
