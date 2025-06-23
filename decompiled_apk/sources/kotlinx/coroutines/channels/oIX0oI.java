package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.OI0;
import kotlinx.coroutines.XX0xXo;
import kotlinx.coroutines.Xx000oIo;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public class oIX0oI<E> extends II0XooXoX<E> implements I0Io<E> {
    public oIX0oI(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO, boolean z) {
        super(coroutineContext, oxx0IOOO, false, z);
        IIX0((oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void O0IxXx(@OXOo.oOoXoXO Throwable th) {
        Oxx0IOOO<E> OooI2 = OooI();
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = XX0xXo.oIX0oI(OI0.oIX0oI(this) + " was cancelled", th);
            }
        }
        OooI2.II0xO0(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean oOo(@OXOo.OOXIXo Throwable th) {
        Xx000oIo.II0xO0(getContext(), th);
        return true;
    }
}
