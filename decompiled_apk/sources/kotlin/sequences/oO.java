package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

@kotlin.coroutines.Oxx0IOOO
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class oO<T> {
    @OXOo.oOoXoXO
    public abstract Object II0xO0(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io);

    @OXOo.oOoXoXO
    public abstract Object X0o0xo(@OXOo.OOXIXo Iterator<? extends T> it, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io);

    @OXOo.oOoXoXO
    public final Object XO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object X0o0xo2 = X0o0xo(ooooo0oxi.iterator(), i0Io);
        if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return X0o0xo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object oxoX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return oXIO0o0XI.f29392oIX0oI;
        }
        Object X0o0xo2 = X0o0xo(iterable.iterator(), i0Io);
        if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return X0o0xo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
