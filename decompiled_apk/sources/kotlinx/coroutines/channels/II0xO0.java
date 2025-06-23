package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.IxIX0I;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public final class II0xO0 {
    public static /* synthetic */ oI0IIXIo II0xO0(xII xii, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Oox.oOoXoXO oooxoxo, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        int i3;
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            oooxoxo = null;
        }
        return oIX0oI(xii, coroutineContext2, i3, coroutineStart2, oooxoxo, x0xo0oo);
    }

    @IxIX0I
    @OXOo.OOXIXo
    public static final <E> oI0IIXIo<E> oIX0oI(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo Oox.x0xO0oo<? super I0Io<E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        oIX0oI oix0oi;
        CoroutineContext X0o0xo2 = CoroutineContextKt.X0o0xo(xii, coroutineContext);
        Oxx0IOOO oxoX2 = xxIXOIIO.oxoX(i, null, null, 6, null);
        if (coroutineStart.isLazy()) {
            oix0oi = new LazyActorCoroutine(X0o0xo2, oxoX2, x0xo0oo);
        } else {
            oix0oi = new oIX0oI(X0o0xo2, oxoX2, true);
        }
        if (oooxoxo != null) {
            ((JobSupport) oix0oi).Oo(oooxoxo);
        }
        ((kotlinx.coroutines.oIX0oI) oix0oi).OO0(coroutineStart, oix0oi, x0xo0oo);
        return (oI0IIXIo<E>) oix0oi;
    }
}
