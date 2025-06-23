package xoIXOxX;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import xx0o0O.XO;

@xxIXOIIO(name = "TimersKt")
/* loaded from: classes6.dex */
public final class I0Io {

    @XX({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n*L\n1#1,148:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI extends TimerTask {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO<TimerTask, oXIO0o0XI> f34942XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(oOoXoXO<? super TimerTask, oXIO0o0XI> oooxoxo) {
            this.f34942XO = oooxoxo;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f34942XO.invoke(this);
        }
    }

    public static /* synthetic */ Timer I0Io(String str, boolean z, long j, long j2, oOoXoXO action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.scheduleAtFixedRate(new oIX0oI(action), j, j2);
        return OOXIXo2;
    }

    @XO
    public static final TimerTask II0XooXoX(Timer timer, Date time, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(timer, "<this>");
        IIX0o.x0xO0oo(time, "time");
        IIX0o.x0xO0oo(action, "action");
        oIX0oI oix0oi = new oIX0oI(action);
        timer.schedule(oix0oi, time);
        return oix0oi;
    }

    @XO
    public static final Timer II0xO0(String str, boolean z, Date startAt, long j, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(startAt, "startAt");
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.scheduleAtFixedRate(new oIX0oI(action), startAt, j);
        return OOXIXo2;
    }

    @OOXIXo
    @o0
    public static final Timer OOXIXo(@OXOo.oOoXoXO String str, boolean z) {
        if (str == null) {
            return new Timer(z);
        }
        return new Timer(str, z);
    }

    @XO
    public static final TimerTask Oxx0IOOO(Timer timer, Date time, long j, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(timer, "<this>");
        IIX0o.x0xO0oo(time, "time");
        IIX0o.x0xO0oo(action, "action");
        oIX0oI oix0oi = new oIX0oI(action);
        timer.schedule(oix0oi, time, j);
        return oix0oi;
    }

    @XO
    public static final TimerTask X0o0xo(Timer timer, long j, long j2, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(timer, "<this>");
        IIX0o.x0xO0oo(action, "action");
        oIX0oI oix0oi = new oIX0oI(action);
        timer.schedule(oix0oi, j, j2);
        return oix0oi;
    }

    @XO
    public static final TimerTask XO(Timer timer, long j, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(timer, "<this>");
        IIX0o.x0xO0oo(action, "action");
        oIX0oI oix0oi = new oIX0oI(action);
        timer.schedule(oix0oi, j);
        return oix0oi;
    }

    @XO
    public static final Timer oIX0oI(String str, boolean z, long j, long j2, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.scheduleAtFixedRate(new oIX0oI(action), j, j2);
        return OOXIXo2;
    }

    public static /* synthetic */ Timer oO(String str, boolean z, Date startAt, long j, oOoXoXO action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        IIX0o.x0xO0oo(startAt, "startAt");
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.schedule(new oIX0oI(action), startAt, j);
        return OOXIXo2;
    }

    @XO
    public static final Timer oOoXoXO(String str, boolean z, long j, long j2, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.schedule(new oIX0oI(action), j, j2);
        return OOXIXo2;
    }

    @XO
    public static final Timer ooOOo0oXI(String str, boolean z, Date startAt, long j, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(startAt, "startAt");
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.schedule(new oIX0oI(action), startAt, j);
        return OOXIXo2;
    }

    public static /* synthetic */ Timer oxoX(String str, boolean z, Date startAt, long j, oOoXoXO action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        IIX0o.x0xO0oo(startAt, "startAt");
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.scheduleAtFixedRate(new oIX0oI(action), startAt, j);
        return OOXIXo2;
    }

    public static /* synthetic */ Timer x0XOIxOo(String str, boolean z, long j, long j2, oOoXoXO action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        IIX0o.x0xO0oo(action, "action");
        Timer OOXIXo2 = OOXIXo(str, z);
        OOXIXo2.schedule(new oIX0oI(action), j, j2);
        return OOXIXo2;
    }

    @XO
    public static final TimerTask x0xO0oo(oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        return new oIX0oI(action);
    }

    @XO
    public static final TimerTask xoIox(Timer timer, Date time, long j, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(timer, "<this>");
        IIX0o.x0xO0oo(time, "time");
        IIX0o.x0xO0oo(action, "action");
        oIX0oI oix0oi = new oIX0oI(action);
        timer.scheduleAtFixedRate(oix0oi, time, j);
        return oix0oi;
    }

    @XO
    public static final TimerTask xxIXOIIO(Timer timer, long j, long j2, oOoXoXO<? super TimerTask, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(timer, "<this>");
        IIX0o.x0xO0oo(action, "action");
        oIX0oI oix0oi = new oIX0oI(action);
        timer.scheduleAtFixedRate(oix0oi, j, j2);
        return oix0oi;
    }
}
