package androidx.core.util;

import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class RunnableKt {
    @OXOo.OOXIXo
    public static final Runnable asRunnable(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return new ContinuationRunnable(i0Io);
    }
}
