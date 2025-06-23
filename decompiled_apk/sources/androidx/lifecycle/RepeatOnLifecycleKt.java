package androidx.lifecycle;

import Oox.x0xO0oo;
import androidx.lifecycle.Lifecycle;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt {
    @OXOo.oOoXoXO
    public static final Object repeatOnLifecycle(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Lifecycle.State state, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (state != Lifecycle.State.INITIALIZED) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                return oXIO0o0XI.f29392oIX0oI;
            }
            Object Oxx0IOOO2 = x0o.Oxx0IOOO(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, x0xo0oo, null), i0Io);
            return Oxx0IOOO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO() ? Oxx0IOOO2 : oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    @OXOo.oOoXoXO
    public static final Object repeatOnLifecycle(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo Lifecycle.State state, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, x0xo0oo, i0Io);
        return repeatOnLifecycle == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO() ? repeatOnLifecycle : oXIO0o0XI.f29392oIX0oI;
    }
}
