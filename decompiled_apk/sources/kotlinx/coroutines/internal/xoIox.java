package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class xoIox {
    public static final void oIX0oI(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Throwable th) {
        Iterator<kotlinx.coroutines.oOXoIIIo> it = xxIXOIIO.II0xO0().iterator();
        while (it.hasNext()) {
            try {
                it.next().IXxxXO(coroutineContext, th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                xxIXOIIO.I0Io(kotlinx.coroutines.Xx000oIo.I0Io(th, th2));
            }
        }
        try {
            kotlin.oO.oIX0oI(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        xxIXOIIO.I0Io(th);
    }
}
