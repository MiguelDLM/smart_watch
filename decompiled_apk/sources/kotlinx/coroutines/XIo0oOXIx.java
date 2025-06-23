package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.OO0x0xX;

/* loaded from: classes6.dex */
public abstract class XIo0oOXIx extends x0xO {
    public final void OI0() {
        kotlin.oXIO0o0XI oxio0o0xi;
        Thread x0o2 = x0o();
        if (Thread.currentThread() != x0o2) {
            II0xO0 II0xO02 = I0Io.II0xO0();
            if (II0xO02 != null) {
                II0xO02.Oxx0IOOO(x0o2);
                oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
            } else {
                oxio0o0xi = null;
            }
            if (oxio0o0xi == null) {
                LockSupport.unpark(x0o2);
            }
        }
    }

    public void XOxIOxOx(long j, @OXOo.OOXIXo OO0x0xX.I0Io i0Io) {
        o0.f30326IIXOooo.XX0(j, i0Io);
    }

    @OXOo.OOXIXo
    public abstract Thread x0o();
}
