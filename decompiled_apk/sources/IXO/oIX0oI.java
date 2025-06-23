package IXO;

import android.os.Handler;
import com.octopus.ad.a.c;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes11.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public long f732I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Handler f733II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public c f734Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f735X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public IXO.II0xO0 f736XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Timer f737oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f738oxoX;

    /* loaded from: classes11.dex */
    public class II0xO0 extends TimerTask {

        /* renamed from: XO, reason: collision with root package name */
        public long f740XO = -1;

        /* renamed from: IXO.oIX0oI$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0019II0xO0 implements Runnable {
            public RunnableC0019II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (oIX0oI.this.f736XO != null) {
                    oIX0oI.this.f736XO.a(oIX0oI.this.f735X0o0xo);
                }
            }
        }

        /* renamed from: IXO.oIX0oI$II0xO0$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0020oIX0oI implements Runnable {
            public RunnableC0020oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (oIX0oI.this.f736XO != null) {
                    oIX0oI.this.f736XO.a(oIX0oI.this.f735X0o0xo);
                }
            }
        }

        public II0xO0() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f740XO < 0) {
                this.f740XO = scheduledExecutionTime() - (oIX0oI.this.f732I0Io - oIX0oI.this.f735X0o0xo);
                oIX0oI.this.f733II0xO0.post(new RunnableC0020oIX0oI());
                return;
            }
            oIX0oI oix0oi = oIX0oI.this;
            oix0oi.f735X0o0xo = oix0oi.f732I0Io - (scheduledExecutionTime() - this.f740XO);
            oIX0oI.this.f733II0xO0.post(new RunnableC0019II0xO0());
            if (oIX0oI.this.f735X0o0xo <= 0) {
                oIX0oI.this.Oxx0IOOO(false);
            }
        }
    }

    /* renamed from: IXO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class RunnableC0021oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ boolean f744XO;

        public RunnableC0021oIX0oI(boolean z) {
            this.f744XO = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oIX0oI.this.f736XO != null) {
                if (this.f744XO) {
                    oIX0oI.this.f736XO.b();
                } else {
                    oIX0oI.this.f736XO.a();
                }
            }
        }
    }

    public oIX0oI() {
        this.f734Oxx0IOOO = c.FINISH;
        this.f733II0xO0 = new Handler();
    }

    public void I0Io() {
        if (this.f737oIX0oI == null) {
            c cVar = this.f734Oxx0IOOO;
            c cVar2 = c.START;
            if (cVar != cVar2) {
                Timer timer = new Timer();
                this.f737oIX0oI = timer;
                timer.scheduleAtFixedRate(oO(), 0L, this.f738oxoX);
                this.f734Oxx0IOOO = cVar2;
            }
        }
    }

    public final void Oxx0IOOO(boolean z) {
        if (this.f737oIX0oI != null) {
            x0xO0oo();
            this.f734Oxx0IOOO = c.FINISH;
            this.f733II0xO0.post(new RunnableC0021oIX0oI(z));
        }
    }

    public void XO(IXO.II0xO0 iI0xO0) {
        this.f736XO = iI0xO0;
    }

    public TimerTask oO() {
        return new II0xO0();
    }

    public void oOoXoXO() {
        if (this.f734Oxx0IOOO == c.PAUSE) {
            I0Io();
        }
    }

    public final void oxoX(long j) {
        this.f732I0Io = j;
        this.f735X0o0xo = j;
    }

    public void x0XOIxOo() {
        Oxx0IOOO(true);
    }

    public final void x0xO0oo() {
        this.f737oIX0oI.cancel();
        this.f737oIX0oI.purge();
        this.f737oIX0oI = null;
    }

    public final void xoIox(long j) {
        this.f738oxoX = j;
    }

    public void xxIXOIIO() {
        if (this.f737oIX0oI != null && this.f734Oxx0IOOO == c.START) {
            x0xO0oo();
            this.f734Oxx0IOOO = c.PAUSE;
        }
    }

    public oIX0oI(long j, long j2) {
        this.f734Oxx0IOOO = c.FINISH;
        oxoX(j);
        xoIox(j2);
        this.f733II0xO0 = new Handler();
    }
}
