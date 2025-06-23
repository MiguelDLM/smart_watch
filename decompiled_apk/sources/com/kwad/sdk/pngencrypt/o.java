package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes11.dex */
public final class o implements Closeable {
    protected ErrorBehaviour aLq = ErrorBehaviour.STRICT;
    public final boolean aMM;
    protected final c aMN;
    protected final a aMO;
    protected final w aMP;
    protected int aMQ;
    private i<? extends Object> aMR;
    public final k aMq;

    public o(InputStream inputStream, boolean z) {
        this.aMQ = -1;
        a aVar = new a(inputStream);
        this.aMO = aVar;
        boolean z2 = true;
        aVar.bF(true);
        c KR = KR();
        this.aMN = KR;
        try {
            if (aVar.b(KR, 36) != 36) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.aMq = KR.Kr();
            if (KR.Ks() == null) {
                z2 = false;
            }
            this.aMM = z2;
            aJ(5024024L);
            aH(901001001L);
            aI(2024024L);
            this.aMP = new w(KR.aLw);
            a(m.KK());
            this.aMQ = -1;
        } catch (RuntimeException e) {
            this.aMO.close();
            this.aMN.close();
            throw e;
        }
    }

    private void KN() {
        while (true) {
            c cVar = this.aMN;
            if (cVar.aLv < 4) {
                if (this.aMO.a(cVar) <= 0) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Premature ending reading first chunks"));
                }
            } else {
                return;
            }
        }
    }

    private void KQ() {
        this.aMN.bH(false);
    }

    private static c KR() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.aMR = iVar;
    }

    private void aH(long j) {
        this.aMN.aH(901001001L);
    }

    private void aI(long j) {
        this.aMN.aI(2024024L);
    }

    private void aJ(long j) {
        this.aMN.aJ(5024024L);
    }

    public final w KO() {
        if (this.aMN.Kp()) {
            KN();
        }
        return this.aMP;
    }

    public final void KP() {
        KQ();
        if (this.aMN.Kp()) {
            KN();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aMN);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aMO);
    }

    public final void end() {
        try {
            if (this.aMN.Kp()) {
                KN();
            }
            if (this.aMN.Kq() != null && !this.aMN.Kq().isDone()) {
                this.aMN.Kq().Kx();
            }
            while (!this.aMN.isDone() && this.aMO.a(this.aMN) > 0) {
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    public final String toString() {
        return this.aMq.toString() + " interlaced=" + this.aMM;
    }
}
