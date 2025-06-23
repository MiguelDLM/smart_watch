package kotlinx.coroutines.internal;

import kotlinx.coroutines.OX00O0xII;

/* loaded from: classes6.dex */
public final class XOxIOxOx {
    @OX00O0xII
    public static final <T> T II0xO0(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        T invoke;
        synchronized (obj) {
            try {
                invoke = oix0oi.invoke();
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.xxX.oxoX(1);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th;
            }
        }
        kotlin.jvm.internal.xxX.I0Io(1);
        return invoke;
    }

    @OX00O0xII
    public static /* synthetic */ void oIX0oI() {
    }
}
