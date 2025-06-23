package com.baidu.ar;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class dz {
    private static volatile dz pZ;
    private ScheduledExecutorService qb;
    private a qc;
    private boolean qa = true;
    private Runnable qd = new Runnable() { // from class: com.baidu.ar.dz.1
        @Override // java.lang.Runnable
        public void run() {
            if (dz.this.qa || dz.this.qc == null) {
                return;
            }
            dz.this.qc.updateRender();
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void updateRender();
    }

    private dz() {
    }

    /* renamed from: do, reason: not valid java name */
    public static dz m47do() {
        if (pZ == null) {
            synchronized (dz.class) {
                try {
                    if (pZ == null) {
                        pZ = new dz();
                    }
                } finally {
                }
            }
        }
        return pZ;
    }

    private void dp() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.qb = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(this.qd, 0L, 40L, TimeUnit.MILLISECONDS);
    }

    public void a(a aVar) {
        this.qc = aVar;
    }

    public void dq() {
        this.qa = false;
        ScheduledExecutorService scheduledExecutorService = this.qb;
        if (scheduledExecutorService == null || scheduledExecutorService.isTerminated()) {
            dp();
        }
    }

    public void dr() {
        this.qa = true;
    }

    public void release() {
        this.qa = true;
        ScheduledExecutorService scheduledExecutorService = this.qb;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.qb = null;
        }
    }
}
