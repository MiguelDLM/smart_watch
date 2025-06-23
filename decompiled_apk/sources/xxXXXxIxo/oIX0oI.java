package xxXXXxIxo;

import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;
import kotlin.o0;
import kotlin.oO;
import kotlin.oxxXoxO;
import xx0o0O.XO;

@xxIXOIIO(name = "AutoCloseableKt")
/* loaded from: classes6.dex */
public final class oIX0oI {
    @XO
    @oxxXoxO(version = "1.2")
    public static final <T extends AutoCloseable, R> R II0xO0(T t, oOoXoXO<? super T, ? extends R> block) {
        IIX0o.x0xO0oo(block, "block");
        try {
            R invoke = block.invoke(t);
            xxX.oxoX(1);
            oIX0oI(t, null);
            xxX.I0Io(1);
            return invoke;
        } finally {
        }
    }

    @o0
    @oxxXoxO(version = "1.2")
    public static final void oIX0oI(@OXOo.oOoXoXO AutoCloseable autoCloseable, @OXOo.oOoXoXO Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                oO.oIX0oI(th, th2);
            }
        }
    }
}
