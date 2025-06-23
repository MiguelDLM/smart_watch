package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.aq;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k {
    private final m aDC;
    private final com.kwad.sdk.core.videocache.a aDD;
    private volatile Thread aDH;
    private volatile boolean kI;
    private final Object aDE = new Object();
    private final Object aDF = new Object();
    private volatile int aDI = -1;
    private final AtomicInteger aDG = new AtomicInteger();

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Hn();
        }

        public /* synthetic */ a(k kVar, byte b) {
            this();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aDC = (m) aq.checkNotNull(mVar);
        this.aDD = (com.kwad.sdk.core.videocache.a) aq.checkNotNull(aVar);
    }

    private void Hk() {
        int i = this.aDG.get();
        if (i <= 0) {
            return;
        }
        this.aDG.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private synchronized void Hl() {
        boolean z;
        try {
            byte b = 0;
            if (this.aDH != null && this.aDH.getState() != Thread.State.TERMINATED) {
                z = true;
            } else {
                z = false;
            }
            if (!this.kI && !this.aDD.isCompleted() && !z) {
                this.aDH = new Thread(new a(this, b), "Source reader for " + this.aDC);
                this.aDH.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void Hm() {
        synchronized (this.aDE) {
            try {
                try {
                    this.aDE.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Hn() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aDD     // Catch: java.lang.Throwable -> L41
            long r2 = r4.GY()     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aDC     // Catch: java.lang.Throwable -> L41
            r4.aA(r2)     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aDC     // Catch: java.lang.Throwable -> L41
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L41
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aDC     // Catch: java.lang.Throwable -> L41
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.aDF     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.Hp()
            r8.j(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.kwad.sdk.core.videocache.a r7 = r8.aDD     // Catch: java.lang.Throwable -> L33
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L41
            r8.Ho()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aDG     // Catch: java.lang.Throwable -> L55
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L55
            onError(r4)     // Catch: java.lang.Throwable -> L55
            goto L2c
        L55:
            r4 = move-exception
            r8.Hp()
            r8.j(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.Hn():void");
    }

    private void Ho() {
        this.aDI = 100;
        dr(this.aDI);
    }

    private void Hp() {
        try {
            this.aDC.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aDC, e));
        }
    }

    private boolean isStopped() {
        if (!Thread.currentThread().isInterrupted() && !this.kI) {
            return false;
        }
        return true;
    }

    private void j(long j, long j2) {
        k(j, j2);
        synchronized (this.aDE) {
            this.aDE.notifyAll();
        }
    }

    private void k(long j, long j2) {
        int i;
        boolean z;
        if (j2 == 0) {
            i = 100;
        } else {
            i = (int) ((((float) j) / ((float) j2)) * 100.0f);
        }
        if (i != this.aDI) {
            z = true;
        } else {
            z = false;
        }
        if (j2 >= 0 && z) {
            dr(i);
        }
        this.aDI = i;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.e.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aDF) {
            try {
                if (!isStopped() && this.aDD.GY() == this.aDC.length()) {
                    this.aDD.complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dr(int i) {
    }

    public final void shutdown() {
        synchronized (this.aDF) {
            try {
                com.kwad.sdk.core.e.c.d("ProxyCache", "Shutdown proxy for " + this.aDC);
                try {
                    this.kI = true;
                    if (this.aDH != null) {
                        this.aDH.interrupt();
                    }
                    this.aDD.close();
                } catch (ProxyCacheException e) {
                    onError(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int a(byte[] bArr, long j, int i) {
        l.b(bArr, j, 1024);
        while (!this.aDD.isCompleted() && this.aDD.GY() < 1024 + j && !this.kI) {
            Hl();
            Hm();
            Hk();
        }
        int a2 = this.aDD.a(bArr, j, 1024);
        if (this.aDD.isCompleted() && this.aDI != 100) {
            this.aDI = 100;
            dr(100);
        }
        return a2;
    }
}
