package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlinx.coroutines.IxIX0I;
import kotlinx.coroutines.internal.x0o;

/* loaded from: classes6.dex */
public final class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29883oIX0oI = new x0o("NO_ELEMENT");

    public static final /* synthetic */ x0o II0xO0() {
        return f29883oIX0oI;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported")
    @IxIX0I
    @OXOo.OOXIXo
    public static final <E> oxoX<E> oIX0oI(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != Integer.MAX_VALUE) {
                        return new BroadcastChannelImpl(i);
                    }
                    throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
                }
                throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
            }
            return new ooOOo0oXI();
        }
        return new BroadcastChannelImpl(Oxx0IOOO.f29871xoIox.oIX0oI());
    }
}
