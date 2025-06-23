package kotlin.coroutines.jvm.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(@oOoXoXO I0Io<Object> i0Io) {
        super(i0Io);
        if (i0Io != null && i0Io.getContext() != EmptyCoroutineContext.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // kotlin.coroutines.I0Io
    @OOXIXo
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
