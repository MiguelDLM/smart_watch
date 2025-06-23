package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;

/* loaded from: classes11.dex */
public final class c extends InputStream {
    private InputStream ST;
    private int SU;
    private volatile float SW;
    private volatile long SX;
    private int SQ = -1;
    private int SR = 10000;
    private long SS = -1;
    private long SV = -1;
    private int SY = 20480;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.ST = inputStream;
        this.SW = i / 1000.0f;
    }

    @WorkerThread
    private static void H(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private void rh() {
        this.SQ = 0;
        this.SS = System.currentTimeMillis();
    }

    private void ri() {
        if (this.SQ < this.SR) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.SS;
        float f = this.SQ / this.SW;
        this.SX = g(this.SU, currentTimeMillis - this.SV);
        if (f > ((float) j)) {
            H(f - r0);
        }
        rh();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.ST.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.ST.close();
        b.a(this);
        this.SV = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.ST.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.ST.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.SV <= 0) {
            this.SV = System.currentTimeMillis();
        }
        this.SU++;
        if (b.SO && b.SN) {
            if (this.SQ < 0) {
                rh();
            }
            int read = this.ST.read();
            this.SQ++;
            ri();
            return read;
        }
        return this.ST.read();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.ST.reset();
    }

    public final long rg() {
        return this.SX;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.ST.skip(j);
    }
}
