package androidx.work;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;

public final class TracerKt {
    public static final <T> T traced(@OOXIXo Tracer tracer, @OOXIXo String str, @OOXIXo oIX0oI<? extends T> oix0oi) {
        IIX0o.x0xO0oo(tracer, "<this>");
        IIX0o.x0xO0oo(str, TTDownloadField.TT_LABEL);
        IIX0o.x0xO0oo(oix0oi, "block");
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(str);
            } catch (Throwable th) {
                xxX.oxoX(1);
                if (isEnabled) {
                    tracer.endSection();
                }
                xxX.I0Io(1);
                throw th;
            }
        }
        T invoke = oix0oi.invoke();
        xxX.oxoX(1);
        if (isEnabled) {
            tracer.endSection();
        }
        xxX.I0Io(1);
        return invoke;
    }
}
