package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;

public final class RepeatOnLifecycleKt {
    @oOoXoXO
    public static final Object repeatOnLifecycle(@OOXIXo Lifecycle lifecycle, @OOXIXo Lifecycle.State state, @OOXIXo x0xO0oo<? super xII, ? super I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        } else if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return oXIO0o0XI.f19155oIX0oI;
        } else {
            Object Oxx0IOOO2 = x0o.Oxx0IOOO(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, x0xo0oo, (I0Io<? super RepeatOnLifecycleKt$repeatOnLifecycle$3>) null), i0Io);
            return Oxx0IOOO2 == II0xO0.oOoXoXO() ? Oxx0IOOO2 : oXIO0o0XI.f19155oIX0oI;
        }
    }

    @oOoXoXO
    public static final Object repeatOnLifecycle(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.State state, @OOXIXo x0xO0oo<? super xII, ? super I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, x0xo0oo, i0Io);
        return repeatOnLifecycle == II0xO0.oOoXoXO() ? repeatOnLifecycle : oXIO0o0XI.f19155oIX0oI;
    }
}
