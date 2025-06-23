package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object I0Io(X0o0xo<? extends T> x0o0xo, Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(x0xo0oo);
        xxX.X0o0xo(0);
        x0o0xo.collect(flowKt__CollectKt$collect$3, i0Io);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.OOXIXo
    public static final <T> kotlinx.coroutines.oXIO0o0XI II0XooXoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii) {
        kotlinx.coroutines.oXIO0o0XI XO2;
        XO2 = kotlinx.coroutines.xoIox.XO(xii, null, null, new FlowKt__CollectKt$launchIn$1(x0o0xo, null), 3, null);
        return XO2;
    }

    @OXOo.oOoXoXO
    public static final Object II0xO0(@OXOo.OOXIXo X0o0xo<?> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = x0o0xo.collect(kotlinx.coroutines.flow.internal.OOXIXo.f30184XO, i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public static final <T> Object Oxx0IOOO(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Oxx0IOOO.x0xO(xo2);
        Object collect = x0o0xo.collect(xo2, i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public static final <T> Object X0o0xo(X0o0xo<? extends T> x0o0xo, Oox.IXxxXO<? super Integer, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(iXxxXO);
        xxX.X0o0xo(0);
        x0o0xo.collect(flowKt__CollectKt$collectIndexed$2, i0Io);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public static final <T> Object XO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        X0o0xo oxoX2;
        oxoX2 = II0XooXoX.oxoX(Oxx0IOOO.XXoOx0(x0o0xo, x0xo0oo), 0, null, 2, null);
        Object OxI2 = Oxx0IOOO.OxI(oxoX2, i0Io);
        if (OxI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return OxI2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object oIX0oI(X0o0xo<? extends T> x0o0xo, Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = x0o0xo.collect(new FlowKt__CollectKt$collect$3(x0xo0oo), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public static final <T> Object oxoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = x0o0xo.collect(new FlowKt__CollectKt$collectIndexed$2(iXxxXO), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
