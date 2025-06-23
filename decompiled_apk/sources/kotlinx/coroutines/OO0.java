package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* loaded from: classes6.dex */
public final class OO0 {
    @OXOo.oOoXoXO
    public static final Object oIX0oI(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        kotlinx.coroutines.internal.oOoXoXO oooxoxo;
        Object obj;
        CoroutineContext context = i0Io.getContext();
        IIX0.O0xOxO(context);
        kotlin.coroutines.I0Io X0o0xo2 = IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io);
        if (X0o0xo2 instanceof kotlinx.coroutines.internal.oOoXoXO) {
            oooxoxo = (kotlinx.coroutines.internal.oOoXoXO) X0o0xo2;
        } else {
            oooxoxo = null;
        }
        if (oooxoxo == null) {
            obj = kotlin.oXIO0o0XI.f29392oIX0oI;
        } else {
            if (oooxoxo.f30300Oxx0xo.isDispatchNeeded(context)) {
                oooxoxo.ooOOo0oXI(context, kotlin.oXIO0o0XI.f29392oIX0oI);
            } else {
                XoIxOXIXo xoIxOXIXo = new XoIxOXIXo();
                CoroutineContext plus = context.plus(xoIxOXIXo);
                kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                oooxoxo.ooOOo0oXI(plus, oxio0o0xi);
                if (xoIxOXIXo.f29786XO) {
                    if (kotlinx.coroutines.internal.ooOOo0oXI.XO(oooxoxo)) {
                        obj = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
                    } else {
                        obj = oxio0o0xi;
                    }
                }
            }
            obj = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        if (obj == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (obj == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return obj;
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }
}
