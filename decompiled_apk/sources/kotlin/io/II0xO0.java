package kotlin.io;

import java.io.Closeable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;
import kotlin.o0;
import kotlin.oO;
import kotlin.oxxXoxO;

@XO0OX.xxIXOIIO(name = "CloseableKt")
/* loaded from: classes6.dex */
public final class II0xO0 {
    @xx0o0O.XO
    public static final <T extends Closeable, R> R II0xO0(T t, Oox.oOoXoXO<? super T, ? extends R> block) {
        IIX0o.x0xO0oo(block, "block");
        try {
            R invoke = block.invoke(t);
            xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                oIX0oI(t, null);
            } else if (t != null) {
                t.close();
            }
            xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (t != null) {
                        try {
                            t.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    oIX0oI(t, th);
                }
                xxX.I0Io(1);
                throw th2;
            }
        }
    }

    @o0
    @oxxXoxO(version = "1.1")
    public static final void oIX0oI(@OXOo.oOoXoXO Closeable closeable, @OXOo.oOoXoXO Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                oO.oIX0oI(th, th2);
            }
        }
    }
}
