package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class IIXOooo {
    public static final void II0xO0(@OXOo.OOXIXo AtomicInteger atomicInteger, int i) {
        atomicInteger.set(i);
    }

    public static final int oIX0oI(@OXOo.OOXIXo AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }
}
