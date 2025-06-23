package com.baidu.ar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public abstract class nr extends nt {
    private boolean HK;
    private boolean HL;
    private ScheduledExecutorService HM;
    private ScheduledFuture HN;
    private final pq HJ = pr.a((Class<?>) nr.class);
    private long HO = TimeUnit.SECONDS.toNanos(60);
    private boolean HP = false;
    private final Object HQ = new Object();

    private void iU() {
        iW();
        this.HM = Executors.newSingleThreadScheduledExecutor(new po("connectionLostChecker"));
        Runnable runnable = new Runnable() { // from class: com.baidu.ar.nr.1
            private ArrayList<ns> HR = new ArrayList<>();

            @Override // java.lang.Runnable
            public void run() {
                this.HR.clear();
                try {
                    this.HR.addAll(nr.this.iV());
                    long nanoTime = (long) (System.nanoTime() - (nr.this.HO * 1.5d));
                    Iterator<ns> it = this.HR.iterator();
                    while (it.hasNext()) {
                        nr.this.a(it.next(), nanoTime);
                    }
                } catch (Exception unused) {
                }
                this.HR.clear();
            }
        };
        ScheduledExecutorService scheduledExecutorService = this.HM;
        long j = this.HO;
        this.HN = scheduledExecutorService.scheduleAtFixedRate(runnable, j, j, TimeUnit.NANOSECONDS);
    }

    private void iW() {
        ScheduledExecutorService scheduledExecutorService = this.HM;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.HM = null;
        }
        ScheduledFuture scheduledFuture = this.HN;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.HN = null;
        }
    }

    public void aj(boolean z) {
        this.HL = z;
    }

    public void iS() {
        synchronized (this.HQ) {
            try {
                if (this.HM == null) {
                    if (this.HN != null) {
                    }
                }
                this.HP = false;
                this.HJ.cP("Connection lost timer stopped");
                iW();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void iT() {
        synchronized (this.HQ) {
            try {
                if (this.HO <= 0) {
                    this.HJ.cP("Connection lost timer deactivated");
                    return;
                }
                this.HJ.cP("Connection lost timer started");
                this.HP = true;
                iU();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Collection<ns> iV();

    public boolean iX() {
        return this.HK;
    }

    public boolean iY() {
        return this.HL;
    }

    public void setTcpNoDelay(boolean z) {
        this.HK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ns nsVar, long j) {
        if (nsVar instanceof nu) {
            nu nuVar = (nu) nsVar;
            if (nuVar.jd() < j) {
                this.HJ.b("Closing connection due to no pong received: {}", nuVar);
                nuVar.f(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (nuVar.isOpen()) {
                nuVar.ja();
            } else {
                this.HJ.b("Trying to ping a non open connection: {}", nuVar);
            }
        }
    }
}
