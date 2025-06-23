package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.Xx000oIo;

/* loaded from: classes6.dex */
public final class Oxx0IOOO<T> extends Xx000oIo<T> {
    public Oxx0IOOO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        super(coroutineContext, i0Io);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean xoIxX(@OXOo.OOXIXo Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return O0Xx(th);
    }
}
