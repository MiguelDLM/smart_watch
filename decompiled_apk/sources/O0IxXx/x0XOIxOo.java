package O0IxXx;

import com.octopus.ad.internal.b.l;
import com.octopus.ad.internal.b.p;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class x0XOIxOo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final O0IxXx.oIX0oI f1242II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public volatile boolean f1243Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public volatile Thread f1245XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final x0xO0oo f1246oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public final Object f1240I0Io = new Object();

    /* renamed from: oxoX, reason: collision with root package name */
    public final Object f1247oxoX = new Object();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public volatile int f1241II0XooXoX = -1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final AtomicInteger f1244X0o0xo = new AtomicInteger();

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x0XOIxOo.this.OOXIXo();
        }
    }

    public x0XOIxOo(x0xO0oo x0xo0oo, O0IxXx.oIX0oI oix0oi) {
        this.f1246oIX0oI = (x0xO0oo) ooOOo0oXI.oIX0oI(x0xo0oo);
        this.f1242II0xO0 = (O0IxXx.oIX0oI) ooOOo0oXI.oIX0oI(oix0oi);
    }

    public final void II0XooXoX(long j, long j2) {
        oxoX(j, j2);
        synchronized (this.f1240I0Io) {
            this.f1240I0Io.notifyAll();
        }
    }

    public void II0xO0() {
        synchronized (this.f1247oxoX) {
            try {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18699oI0IIXIo, "Shutdown proxy for " + this.f1246oIX0oI);
                try {
                    this.f1243Oxx0IOOO = true;
                    if (this.f1245XO != null) {
                        this.f1245XO.interrupt();
                    }
                    this.f1242II0xO0.b();
                } catch (p e) {
                    XO(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void OOXIXo() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.f1242II0xO0.a();
            this.f1246oIX0oI.a(j2);
            j = this.f1246oIX0oI.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f1246oIX0oI.a(bArr);
                if (a2 != -1) {
                    synchronized (this.f1247oxoX) {
                        if (x0XOIxOo()) {
                            return;
                        } else {
                            this.f1242II0xO0.a(bArr, a2);
                        }
                    }
                    j2 += a2;
                    II0XooXoX(j2, j);
                } else {
                    ooOOo0oXI();
                    oOoXoXO();
                    break;
                }
            }
        } catch (Throwable th) {
            try {
                this.f1244X0o0xo.incrementAndGet();
                XO(th);
            } finally {
                oO();
                II0XooXoX(j2, j);
            }
        }
    }

    public final void Oxx0IOOO() throws p {
        int i = this.f1244X0o0xo.get();
        if (i < 1) {
            return;
        }
        this.f1244X0o0xo.set(0);
        throw new p("Error reading source " + i + " times");
    }

    public final void XO(Throwable th) {
        if (th instanceof l) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18699oI0IIXIo, "ProxyCache is interrupted");
        } else {
            com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18699oI0IIXIo, "ProxyCache error", th);
        }
    }

    public int oIX0oI(byte[] bArr, long j, int i) throws p {
        oO.oxoX(bArr, j, i);
        while (!this.f1242II0xO0.d() && this.f1242II0xO0.a() < i + j && !this.f1243Oxx0IOOO) {
            xxIXOIIO();
            xoIox();
            Oxx0IOOO();
        }
        int a2 = this.f1242II0xO0.a(bArr, j, i);
        if (this.f1242II0xO0.d() && this.f1241II0XooXoX != 100) {
            this.f1241II0XooXoX = 100;
            I0Io(100);
        }
        return a2;
    }

    public final void oO() {
        try {
            this.f1246oIX0oI.b();
        } catch (p e) {
            XO(new p("Error closing source " + this.f1246oIX0oI, e));
        }
    }

    public final void oOoXoXO() {
        this.f1241II0XooXoX = 100;
        I0Io(this.f1241II0XooXoX);
    }

    public final void ooOOo0oXI() throws p {
        synchronized (this.f1247oxoX) {
            try {
                if (!x0XOIxOo() && this.f1242II0xO0.a() == this.f1246oIX0oI.a()) {
                    this.f1242II0xO0.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void oxoX(long j, long j2) {
        int i;
        boolean z;
        if (j2 == 0) {
            i = 100;
        } else {
            i = (int) ((((float) j) / ((float) j2)) * 100.0f);
        }
        if (i != this.f1241II0XooXoX) {
            z = true;
        } else {
            z = false;
        }
        if (j2 >= 0 && z) {
            I0Io(i);
        }
        this.f1241II0XooXoX = i;
    }

    public final boolean x0XOIxOo() {
        if (!Thread.currentThread().isInterrupted() && !this.f1243Oxx0IOOO) {
            return false;
        }
        return true;
    }

    public final void xoIox() throws p {
        synchronized (this.f1240I0Io) {
            try {
                try {
                    this.f1240I0Io.wait(1000L);
                } catch (InterruptedException e) {
                    throw new p("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void xxIXOIIO() throws p {
        boolean z;
        try {
            if (this.f1245XO != null && this.f1245XO.getState() != Thread.State.TERMINATED) {
                z = true;
            } else {
                z = false;
            }
            if (!this.f1243Oxx0IOOO && !this.f1242II0xO0.d() && !z) {
                this.f1245XO = new Thread(new II0xO0(), "Source reader for " + this.f1246oIX0oI);
                this.f1245XO.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void I0Io(int i) {
    }
}
