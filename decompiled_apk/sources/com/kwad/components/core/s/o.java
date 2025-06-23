package com.kwad.components.core.s;

import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public final class o implements Runnable {
    private WeakReference<Runnable> weakReference;

    public o(Runnable runnable) {
        this.weakReference = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.weakReference.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
