package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public class xxOXOOoIX extends oIX0oI<kotlin.oXIO0o0XI> {
    public xxOXOOoIX(@OXOo.OOXIXo CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean oOo(@OXOo.OOXIXo Throwable th) {
        Xx000oIo.II0xO0(getContext(), th);
        return true;
    }
}
