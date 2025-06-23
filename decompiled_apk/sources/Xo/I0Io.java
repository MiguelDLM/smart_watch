package Xo;

import IIOIX.II0xO0;
import IIOIX.oIX0oI;
import android.content.Context;
import com.tanx.exposer.achieve.AdMonitorType;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import oX000x.oIX0oI;

/* loaded from: classes13.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public Xo.II0xO0 f4144I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f4145II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xIx.I0Io f4146II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final oIX0oI.I0Io f4147Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public AtomicInteger f4148X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f4149XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f4150oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public oxoX f4151oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ConcurrentLinkedQueue<com.tanx.exposer.achieve.II0xO0> f4152xxIXOIIO;

    /* renamed from: Xo.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0068I0Io implements Runnable {
        public RunnableC0068I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I0Io.this.II0XooXoX();
            String oIX0oI2 = XOxoX.II0xO0.oIX0oI(System.currentTimeMillis(), "yyyy-MM-dd");
            XOxoX.oIX0oI.oIX0oI("AdRetryExposeManager", "currentDate=" + oIX0oI2);
            I0Io i0Io = I0Io.this;
            i0Io.f4144I0Io.oxoX(oIX0oI2, i0Io.f4145II0XooXoX);
            I0Io.this.ooOOo0oXI();
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oIX0oI.oxoX.f32079oIX0oI.oIX0oI(I0Io.this.f4147Oxx0IOOO);
        }
    }

    /* loaded from: classes13.dex */
    public static class X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final I0Io f4155oIX0oI = new I0Io(0);
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements oIX0oI.I0Io {
        public oIX0oI() {
        }

        @Override // oX000x.oIX0oI.I0Io
        public void oIX0oI(int i) {
            boolean z;
            I0Io i0Io = I0Io.this;
            if (i != -1) {
                z = true;
            } else {
                z = false;
            }
            i0Io.f4149XO = z;
            if (z && i0Io.f4146II0xO0.xxIXOIIO() != null && I0Io.this.f4146II0xO0.xxIXOIIO().oxoX()) {
                I0Io.this.oIX0oI();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f4158oIX0oI = 500;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f4157II0xO0 = 5;
    }

    public /* synthetic */ I0Io(byte b) {
        this();
    }

    public void I0Io(Context context, xIx.I0Io i0Io) {
        this.f4150oIX0oI = context;
        this.f4146II0xO0 = i0Io;
        if (i0Io.xxIXOIIO() != null) {
            this.f4145II0XooXoX = i0Io.xxIXOIIO().XO();
        }
        oOoXoXO();
        Oxx0IOOO();
    }

    public synchronized void II0XooXoX() {
        if (this.f4144I0Io == null) {
            this.f4144I0Io = new Xo.II0xO0(this.f4150oIX0oI);
        }
    }

    public boolean OOXIXo(com.tanx.exposer.achieve.II0xO0 iI0xO0) {
        xIx.II0xO0 xxIXOIIO2 = this.f4146II0xO0.xxIXOIIO();
        if (xxIXOIIO2 == null || !xxIXOIIO2.Oxx0IOOO() || !xxIXOIIO2.oIX0oI().contains(iI0xO0.oOoXoXO()) || iI0xO0.I0Io() <= 0 || iI0xO0.II0XooXoX().get() >= iI0xO0.I0Io()) {
            return false;
        }
        return true;
    }

    public final void Oxx0IOOO() {
        IxIo.II0xO0.oIX0oI(new II0xO0(), 10000L);
    }

    public void X0o0xo(com.tanx.exposer.achieve.II0xO0 iI0xO0, int i, String str, boolean z) {
        String obj;
        if (iI0xO0 == null) {
            return;
        }
        if (z) {
            this.f4148X0o0xo.decrementAndGet();
        } else {
            iI0xO0.XO(AdMonitorRetryType.NONE);
            if (iI0xO0.xoIox() == null) {
                obj = "";
            } else {
                obj = iI0xO0.xoIox().toString();
            }
            XoOxI0ox.II0xO0.I0Io().II0xO0("TanxExposer", "EXPOSER_SUCCESS_POINT", String.valueOf(i), str, obj);
        }
        x0oxIIIX.II0xO0.I0Io(iI0xO0, i, str, z, iI0xO0.ooOOo0oXI().name());
        II0XooXoX();
        if (OOXIXo(iI0xO0)) {
            if (!this.f4152xxIXOIIO.contains(iI0xO0)) {
                x0XOIxOo();
                this.f4152xxIXOIIO.add(iI0xO0);
                this.f4144I0Io.I0Io(iI0xO0);
                xxIXOIIO(iI0xO0, i, str, true);
                return;
            }
            return;
        }
        xxIXOIIO(iI0xO0, i, str, false);
    }

    public void XO(com.tanx.exposer.achieve.II0xO0 iI0xO0, boolean z) {
        String obj;
        if (z) {
            this.f4148X0o0xo.decrementAndGet();
        }
        if (iI0xO0 == null) {
            return;
        }
        if (!z) {
            iI0xO0.XO(AdMonitorRetryType.NONE);
            if (iI0xO0.xoIox() == null) {
                obj = "";
            } else {
                obj = iI0xO0.xoIox().toString();
            }
            XoOxI0ox.II0xO0.I0Io().oIX0oI("TanxExposer", "EXPOSER_SUCCESS_POINT", obj);
        }
        x0oxIIIX.II0xO0.oxoX(iI0xO0, z, iI0xO0.ooOOo0oXI().name());
        oXO0oOx0.II0xO0 II0XooXoX2 = xIx.I0Io.I0Io().II0XooXoX();
        if (II0XooXoX2 != null && iI0xO0.ooOOo0oXI() != AdMonitorRetryType.DB) {
            II0XooXoX2.tanxc_do(iI0xO0.xxIXOIIO(), iI0xO0.oOoXoXO(), iI0xO0.xoIox());
        }
        oIX0oI();
    }

    public synchronized void oIX0oI() {
        try {
            int i = this.f4151oxoX.f4157II0xO0 - this.f4148X0o0xo.get();
            XOxoX.oIX0oI.oIX0oI("AdRetryExposeManager", "availableRetryCount=" + i);
            if (i <= 0) {
                return;
            }
            if (this.f4152xxIXOIIO.size() <= 0) {
                return;
            }
            XOxoX.oIX0oI.oIX0oI("AdRetryExposeManager", "failedRequestQueue.size=" + this.f4152xxIXOIIO.size());
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                com.tanx.exposer.achieve.II0xO0 poll = this.f4152xxIXOIIO.poll();
                if (poll != null) {
                    arrayList.add(poll);
                    II0XooXoX();
                    this.f4144I0Io.II0xO0(poll.oxoX());
                }
                i = i2;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                xoIox((com.tanx.exposer.achieve.II0xO0) it.next(), true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void oOoXoXO() {
        IxIo.II0xO0.oIX0oI(new RunnableC0068I0Io(), 0L);
    }

    public final void ooOOo0oXI() {
        II0XooXoX();
        List<com.tanx.exposer.achieve.II0xO0> oIX0oI2 = this.f4144I0Io.oIX0oI(XOxoX.II0xO0.oIX0oI(System.currentTimeMillis(), "yyyy-MM-dd"));
        if (oIX0oI2.isEmpty()) {
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("AdRetryExposeManager", "sendRetryMonitor return because no retry monitor info.");
                return;
            }
            return;
        }
        int size = oIX0oI2.size();
        if (XOxoX.oIX0oI.f3985oIX0oI) {
            XOxoX.oIX0oI.oIX0oI("AdRetryExposeManager", "sendRetryMonitor: count = " + size);
        }
        for (int i = 0; i < size; i++) {
            com.tanx.exposer.achieve.II0xO0 iI0xO0 = oIX0oI2.get(i);
            iI0xO0.XO(AdMonitorRetryType.DB);
            if (OOXIXo(iI0xO0)) {
                if (!this.f4152xxIXOIIO.contains(iI0xO0)) {
                    x0XOIxOo();
                    this.f4152xxIXOIIO.add(iI0xO0);
                } else {
                    this.f4144I0Io.II0xO0(iI0xO0.oxoX());
                }
            } else {
                this.f4144I0Io.II0xO0(iI0xO0.oxoX());
            }
        }
        if (!oIX0oI.oxoX.f32079oIX0oI.II0xO0()) {
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("AdRetryExposeManager", "sendRetryMonitor return because no net.");
                return;
            }
            return;
        }
        oIX0oI();
    }

    public void oxoX(com.tanx.exposer.achieve.II0xO0 iI0xO0) {
        if (iI0xO0 != null && this.f4152xxIXOIIO.contains(iI0xO0) && this.f4152xxIXOIIO.remove(iI0xO0)) {
            xoIox(iI0xO0, false);
        }
    }

    public final void x0XOIxOo() {
        if (this.f4152xxIXOIIO.size() < this.f4151oxoX.f4158oIX0oI) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f4152xxIXOIIO.size() - this.f4151oxoX.f4158oIX0oI);
        while (this.f4152xxIXOIIO.size() >= this.f4151oxoX.f4158oIX0oI) {
            com.tanx.exposer.achieve.II0xO0 poll = this.f4152xxIXOIIO.poll();
            if (poll != null) {
                arrayList.add(poll);
                II0XooXoX();
                this.f4144I0Io.II0xO0(poll.oxoX());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            xxIXOIIO((com.tanx.exposer.achieve.II0xO0) it.next(), -2, "retry fail,exceed max retry count", false);
        }
    }

    public final void xoIox(com.tanx.exposer.achieve.II0xO0 iI0xO0, boolean z) {
        xIOXX.I0Io iI0xO02;
        if (iI0xO0 == null) {
            return;
        }
        if (z) {
            iI0xO0.II0XooXoX().incrementAndGet();
            this.f4148X0o0xo.incrementAndGet();
        }
        X0ooXIooI.II0xO0 iI0xO03 = new X0ooXIooI.II0xO0(this.f4146II0xO0.xxIXOIIO().II0XooXoX());
        if (iI0xO0.oOoXoXO() == AdMonitorType.EXPOSE) {
            iI0xO02 = new II0xO0.C0005II0xO0(iI0xO0, z);
        } else {
            iI0xO02 = new oIX0oI.II0xO0(iI0xO0, z);
        }
        iI0xO03.oIX0oI(iI0xO0.OOXIXo(), iI0xO02);
    }

    public final void xxIXOIIO(com.tanx.exposer.achieve.II0xO0 iI0xO0, int i, String str, boolean z) {
        oXO0oOx0.II0xO0 II0XooXoX2 = xIx.I0Io.I0Io().II0XooXoX();
        if (II0XooXoX2 != null && iI0xO0.ooOOo0oXI() != AdMonitorRetryType.DB) {
            if (z) {
                II0XooXoX2.tanxc_if(i, str, iI0xO0.xxIXOIIO(), iI0xO0.oOoXoXO(), iI0xO0.xoIox());
            } else {
                II0XooXoX2.tanxc_do(i, str, iI0xO0.xxIXOIIO(), iI0xO0.oOoXoXO(), iI0xO0.xoIox());
            }
        }
    }

    public I0Io() {
        this.f4151oxoX = new oxoX();
        this.f4148X0o0xo = new AtomicInteger(0);
        this.f4149XO = true;
        this.f4147Oxx0IOOO = new oIX0oI();
        this.f4145II0XooXoX = 3;
        this.f4152xxIXOIIO = new ConcurrentLinkedQueue<>();
    }
}
