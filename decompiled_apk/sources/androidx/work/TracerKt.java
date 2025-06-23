package androidx.work;

import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;

/* loaded from: classes.dex */
public final class TracerKt {
    public static final <T> T traced(@OXOo.OOXIXo Tracer tracer, @OXOo.OOXIXo String label, @OXOo.OOXIXo Oox.oIX0oI<? extends T> block) {
        IIX0o.x0xO0oo(tracer, "<this>");
        IIX0o.x0xO0oo(label, "label");
        IIX0o.x0xO0oo(block, "block");
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(label);
            } catch (Throwable th) {
                xxX.oxoX(1);
                if (isEnabled) {
                    tracer.endSection();
                }
                xxX.I0Io(1);
                throw th;
            }
        }
        T invoke = block.invoke();
        xxX.oxoX(1);
        if (isEnabled) {
            tracer.endSection();
        }
        xxX.I0Io(1);
        return invoke;
    }
}
