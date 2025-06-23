package androidx.core.os;

import Oox.oIX0oI;
import android.os.Trace;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.jvm.internal.xxX;

public final class TraceKt {
    @OOXIXo(message = "Use androidx.tracing.Trace instead", replaceWith = @XX(expression = "trace(sectionName, block)", imports = {"androidx.tracing.trace"}))
    public static final <T> T trace(@OXOo.OOXIXo String str, @OXOo.OOXIXo oIX0oI<? extends T> oix0oi) {
        Trace.beginSection(str);
        try {
            return oix0oi.invoke();
        } finally {
            xxX.oxoX(1);
            Trace.endSection();
            xxX.I0Io(1);
        }
    }
}
