package androidx.core.util;

import OXOo.OOXIXo;
import kotlin.coroutines.I0Io;
import kotlin.oXIO0o0XI;

public final class RunnableKt {
    @OOXIXo
    public static final Runnable asRunnable(@OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
        return new ContinuationRunnable(i0Io);
    }
}
