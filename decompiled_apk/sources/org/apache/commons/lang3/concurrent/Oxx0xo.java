package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class Oxx0xo {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f32693oOoXoXO = 0;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f32694ooOOo0oXI = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    public final TimeUnit f32695I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f32696II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final long f32697II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f32698OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public long f32699Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ScheduledFuture<?> f32700X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public long f32701XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ScheduledExecutorService f32702oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f32703oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f32704xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f32705xxIXOIIO;

    public Oxx0xo(long j, TimeUnit timeUnit, int i) {
        this(null, j, timeUnit, i);
    }

    public synchronized void I0Io() {
        int i = this.f32705xxIXOIIO;
        this.f32704xoIox = i;
        this.f32701XO += i;
        this.f32699Oxx0IOOO++;
        this.f32705xxIXOIIO = 0;
        notifyAll();
    }

    public synchronized int II0XooXoX() {
        return this.f32704xoIox;
    }

    public final boolean II0xO0() {
        if (xxIXOIIO() > 0 && this.f32705xxIXOIIO >= xxIXOIIO()) {
            return false;
        }
        this.f32705xxIXOIIO++;
        return true;
    }

    public TimeUnit OOXIXo() {
        return this.f32695I0Io;
    }

    public synchronized boolean Oo() {
        ooOOo0oXI();
        return II0xO0();
    }

    public ScheduledExecutorService Oxx0IOOO() {
        return this.f32702oIX0oI;
    }

    public synchronized int X0o0xo() {
        return xxIXOIIO() - oxoX();
    }

    public synchronized double XO() {
        double d;
        long j = this.f32699Oxx0IOOO;
        if (j == 0) {
            d = XIXIX.OOXIXo.f3760XO;
        } else {
            d = this.f32701XO / j;
        }
        return d;
    }

    public synchronized void oIX0oI() throws InterruptedException {
        boolean II0xO02;
        ooOOo0oXI();
        do {
            II0xO02 = II0xO0();
            if (!II0xO02) {
                wait();
            }
        } while (!II0xO02);
    }

    public synchronized void oO() {
        try {
            if (!this.f32698OOXIXo) {
                if (this.f32703oxoX) {
                    Oxx0IOOO().shutdownNow();
                }
                ScheduledFuture<?> scheduledFuture = this.f32700X0o0xo;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f32698OOXIXo = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean oOoXoXO() {
        return this.f32698OOXIXo;
    }

    public final void ooOOo0oXI() {
        if (!oOoXoXO()) {
            if (this.f32700X0o0xo == null) {
                this.f32700X0o0xo = x0xO0oo();
                return;
            }
            return;
        }
        throw new IllegalStateException("TimedSemaphore is shut down!");
    }

    public synchronized int oxoX() {
        return this.f32705xxIXOIIO;
    }

    public final synchronized void x0XOIxOo(int i) {
        this.f32696II0XooXoX = i;
    }

    public ScheduledFuture<?> x0xO0oo() {
        return Oxx0IOOO().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.IXxxXO
            @Override // java.lang.Runnable
            public final void run() {
                Oxx0xo.this.I0Io();
            }
        }, xoIox(), xoIox(), OOXIXo());
    }

    public long xoIox() {
        return this.f32697II0xO0;
    }

    public final synchronized int xxIXOIIO() {
        return this.f32696II0XooXoX;
    }

    public Oxx0xo(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        xoIxX.IXxxXO(1L, Long.MAX_VALUE, j, "Time period must be greater than 0!");
        this.f32697II0xO0 = j;
        this.f32695I0Io = timeUnit;
        if (scheduledExecutorService != null) {
            this.f32702oIX0oI = scheduledExecutorService;
            this.f32703oxoX = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.f32702oIX0oI = scheduledThreadPoolExecutor;
            this.f32703oxoX = true;
        }
        x0XOIxOo(i);
    }
}
