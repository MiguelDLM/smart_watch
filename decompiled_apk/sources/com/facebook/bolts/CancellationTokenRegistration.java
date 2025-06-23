package com.facebook.bolts;

import java.io.Closeable;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class CancellationTokenRegistration implements Closeable {

    @OXOo.oOoXoXO
    private Runnable action;
    private boolean closed;

    @OXOo.oOoXoXO
    private CancellationTokenSource tokenSource;

    public CancellationTokenRegistration(@OXOo.OOXIXo CancellationTokenSource tokenSource, @OXOo.oOoXoXO Runnable runnable) {
        IIX0o.x0xO0oo(tokenSource, "tokenSource");
        this.action = runnable;
        this.tokenSource = tokenSource;
    }

    private final void throwIfClosed() {
        if (!this.closed) {
        } else {
            throw new IllegalStateException("Object already closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            CancellationTokenSource cancellationTokenSource = this.tokenSource;
            if (cancellationTokenSource != null) {
                cancellationTokenSource.unregister$facebook_bolts_release(this);
            }
            this.tokenSource = null;
            this.action = null;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    public final void runAction$facebook_bolts_release() {
        synchronized (this) {
            throwIfClosed();
            Runnable runnable = this.action;
            if (runnable != null) {
                runnable.run();
            }
            close();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }
}
