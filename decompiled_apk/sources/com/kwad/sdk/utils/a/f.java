package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* loaded from: classes11.dex */
public final class f implements Executor {
    private Runnable aTj;
    private Runnable aTk;

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.aTk;
        this.aTj = runnable;
        this.aTk = null;
        if (runnable != null) {
            d.getExecutor().execute(this.aTj);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aTj == null) {
            this.aTj = d(runnable);
            d.getExecutor().execute(this.aTj);
        } else {
            if (this.aTk == null) {
                this.aTk = d(runnable);
            }
        }
    }
}
