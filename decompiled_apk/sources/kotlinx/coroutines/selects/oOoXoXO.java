package kotlinx.coroutines.selects;

import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.xxX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.oO;

/* loaded from: classes6.dex */
public final class oOoXoXO {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void I0Io(oO<? super T> oOVar, T t) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) oOVar.getContext().get(CoroutineDispatcher.Key);
        if (coroutineDispatcher != null) {
            oOVar.X00IoxXI(coroutineDispatcher, t);
        } else {
            Result.oIX0oI oix0oi = Result.Companion;
            oOVar.resumeWith(Result.m287constructorimpl(t));
        }
    }

    @o0
    public static final <R> Object II0XooXoX(Oox.oOoXoXO<? super II0xO0<? super R>, oXIO0o0XI> oooxoxo, kotlin.coroutines.I0Io<? super R> i0Io) {
        xxX.X0o0xo(0);
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(i0Io);
        try {
            oooxoxo.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.xII(th);
        }
        Object x0o2 = unbiasedSelectBuilderImpl.x0o();
        if (x0o2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        xxX.X0o0xo(1);
        return x0o2;
    }

    @o0
    @OXOo.oOoXoXO
    public static final <R> Object Oxx0IOOO(@OXOo.OOXIXo Oox.oOoXoXO<? super II0xO0<? super R>, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(i0Io);
        try {
            oooxoxo.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.xII(th);
        }
        Object x0o2 = unbiasedSelectBuilderImpl.x0o();
        if (x0o2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return x0o2;
    }

    @o0
    @OXOo.oOoXoXO
    public static final <R> Object X0o0xo(@OXOo.OOXIXo Oox.oOoXoXO<? super II0xO0<? super R>, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(i0Io);
        try {
            oooxoxo.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.IO(th);
        }
        Object X00IoxXI2 = selectBuilderImpl.X00IoxXI();
        if (X00IoxXI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return X00IoxXI2;
    }

    @o0
    public static final <R> Object XO(Oox.oOoXoXO<? super II0xO0<? super R>, oXIO0o0XI> oooxoxo, kotlin.coroutines.I0Io<? super R> i0Io) {
        xxX.X0o0xo(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(i0Io);
        try {
            oooxoxo.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.IO(th);
        }
        Object X00IoxXI2 = selectBuilderImpl.X00IoxXI();
        if (X00IoxXI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        xxX.X0o0xo(1);
        return X00IoxXI2;
    }

    public static final void oxoX(oO<?> oOVar, Throwable th) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) oOVar.getContext().get(CoroutineDispatcher.Key);
        if (coroutineDispatcher != null) {
            oOVar.II0XooXoX(coroutineDispatcher, th);
        } else {
            Result.oIX0oI oix0oi = Result.Companion;
            oOVar.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
        }
    }
}
