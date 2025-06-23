package OI0;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import android.util.Log;
import com.bestmafen.baseble.util.LogLevel;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    @oOoXoXO
    public static IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> f1505I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final String f1506II0xO0 = "BaseBle";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f1507oIX0oI = new oIX0oI();

    @oOoXoXO
    public final IXxxXO<LogLevel, String, String, Boolean> I0Io() {
        return f1505I0Io;
    }

    public final void II0xO0(@OOXIXo String msg) {
        IIX0o.x0xO0oo(msg, "msg");
        IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> iXxxXO = f1505I0Io;
        if (iXxxXO != null) {
            IIX0o.ooOOo0oXI(iXxxXO);
            if (iXxxXO.invoke(LogLevel.E, f1506II0xO0, msg).booleanValue()) {
                return;
            }
        }
        Log.e(f1506II0xO0, msg);
    }

    public final void Oxx0IOOO(@OOXIXo String msg) {
        IIX0o.x0xO0oo(msg, "msg");
        IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> iXxxXO = f1505I0Io;
        if (iXxxXO != null) {
            IIX0o.ooOOo0oXI(iXxxXO);
            if (iXxxXO.invoke(LogLevel.W, f1506II0xO0, msg).booleanValue()) {
                return;
            }
        }
        Log.w(f1506II0xO0, msg);
    }

    public final void X0o0xo(@oOoXoXO IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> iXxxXO) {
        f1505I0Io = iXxxXO;
    }

    public final void XO(@OOXIXo String msg) {
        IIX0o.x0xO0oo(msg, "msg");
        IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> iXxxXO = f1505I0Io;
        if (iXxxXO != null) {
            IIX0o.ooOOo0oXI(iXxxXO);
            if (iXxxXO.invoke(LogLevel.V, f1506II0xO0, msg).booleanValue()) {
                return;
            }
        }
        Log.v(f1506II0xO0, msg);
    }

    public final void oIX0oI(@OOXIXo String msg) {
        IIX0o.x0xO0oo(msg, "msg");
        IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> iXxxXO = f1505I0Io;
        if (iXxxXO != null) {
            IIX0o.ooOOo0oXI(iXxxXO);
            if (iXxxXO.invoke(LogLevel.D, f1506II0xO0, msg).booleanValue()) {
                return;
            }
        }
        Log.d(f1506II0xO0, msg);
    }

    public final void oxoX(@OOXIXo String msg) {
        IIX0o.x0xO0oo(msg, "msg");
        IXxxXO<? super LogLevel, ? super String, ? super String, Boolean> iXxxXO = f1505I0Io;
        if (iXxxXO != null) {
            IIX0o.ooOOo0oXI(iXxxXO);
            if (iXxxXO.invoke(LogLevel.I, f1506II0xO0, msg).booleanValue()) {
                return;
            }
        }
        Log.i(f1506II0xO0, msg);
    }
}
