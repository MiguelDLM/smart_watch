package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, xII {

    @OXOo.OOXIXo
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(@OXOo.OOXIXo CoroutineContext context) {
        IIX0o.x0xO0oo(context, "context");
        this.coroutineContext = context;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Ox0O.xxIXOIIO(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.xII
    @OXOo.OOXIXo
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
