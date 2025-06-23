package androidx.collection.internal;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;

public final class Lock {
    public final <T> T synchronizedImpl(@OOXIXo oIX0oI<? extends T> oix0oi) {
        T invoke;
        IIX0o.x0xO0oo(oix0oi, "block");
        synchronized (this) {
            try {
                invoke = oix0oi.invoke();
                xxX.oxoX(1);
            } catch (Throwable th) {
                xxX.oxoX(1);
                xxX.I0Io(1);
                throw th;
            }
        }
        xxX.I0Io(1);
        return invoke;
    }
}
