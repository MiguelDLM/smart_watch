package com.facebook.bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;

    @OXOo.oOoXoXO
    private ScheduledFuture<?> scheduledCancellation;

    @OXOo.OOXIXo
    private final Object lock = new Object();

    @OXOo.OOXIXo
    private final List<CancellationTokenRegistration> registrations = new ArrayList();

    @OXOo.OOXIXo
    private final ScheduledExecutorService executor = BoltsExecutors.Companion.scheduled$facebook_bolts_release();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancelAfter$lambda-6$lambda-5, reason: not valid java name */
    public static final void m178cancelAfter$lambda6$lambda5(CancellationTokenSource this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.scheduledCancellation = null;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
        this$0.cancel();
    }

    private final void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(true);
        this.scheduledCancellation = null;
    }

    private final void notifyListeners(List<CancellationTokenRegistration> list) {
        Iterator<CancellationTokenRegistration> it = list.iterator();
        while (it.hasNext()) {
            it.next().runAction$facebook_bolts_release();
        }
    }

    private final void throwIfClosed() {
        if (!this.closed) {
        } else {
            throw new IllegalStateException("Object already closed");
        }
    }

    public final void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            this.cancellationRequested = true;
            ArrayList arrayList = new ArrayList(this.registrations);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            notifyListeners(arrayList);
        }
    }

    public final void cancelAfter(long j) {
        cancelAfter(j, TimeUnit.MILLISECONDS);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                cancelScheduledCancellation();
                Iterator<CancellationTokenRegistration> it = this.registrations.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                this.registrations.clear();
                this.closed = true;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @OXOo.OOXIXo
    public final CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public final boolean isCancellationRequested() {
        boolean z;
        synchronized (this.lock) {
            throwIfClosed();
            z = this.cancellationRequested;
        }
        return z;
    }

    @OXOo.OOXIXo
    public final CancellationTokenRegistration register$facebook_bolts_release(@OXOo.oOoXoXO Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            try {
                throwIfClosed();
                cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
                if (this.cancellationRequested) {
                    cancellationTokenRegistration.runAction$facebook_bolts_release();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } else {
                    this.registrations.add(cancellationTokenRegistration);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancellationTokenRegistration;
    }

    public final void throwIfCancellationRequested$facebook_bolts_release() throws CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (!this.cancellationRequested) {
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } else {
                throw new CancellationException();
            }
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationTokenSource.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())}, 3));
        IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public final void unregister$facebook_bolts_release(@OXOo.OOXIXo CancellationTokenRegistration registration) {
        IIX0o.x0xO0oo(registration, "registration");
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(registration);
        }
    }

    private final void cancelAfter(long j, TimeUnit timeUnit) {
        if (!(j >= -1)) {
            throw new IllegalArgumentException("Delay must be >= -1");
        }
        if (j == 0) {
            cancel();
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.cancellationRequested) {
                    return;
                }
                cancelScheduledCancellation();
                if (j != -1) {
                    this.scheduledCancellation = this.executor.schedule(new Runnable() { // from class: com.facebook.bolts.oIX0oI
                        @Override // java.lang.Runnable
                        public final void run() {
                            CancellationTokenSource.m178cancelAfter$lambda6$lambda5(CancellationTokenSource.this);
                        }
                    }, j, timeUnit);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
