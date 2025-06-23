package OoI0OO;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.time.Duration;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.OOXIxO0;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public final class XO {
    @oOoXoXO
    public static final Object I0Io(@OOXIXo Duration duration, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object II0xO02 = DelayKt.II0xO0(oIX0oI(duration), i0Io);
        if (II0xO02 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return II0xO02;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OOXIXo
    @OOXIxO0
    public static final <T> kotlinx.coroutines.flow.X0o0xo<T> II0xO0(@OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, @OOXIXo Duration duration) {
        return Oxx0IOOO.oxXx0IX(x0o0xo, oIX0oI(duration));
    }

    @oOoXoXO
    public static final <T> Object Oxx0IOOO(@OOXIXo Duration duration, @OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return TimeoutKt.X0o0xo(oIX0oI(duration), x0xo0oo, i0Io);
    }

    @OOXIXo
    @OOXIxO0
    public static final <T> kotlinx.coroutines.flow.X0o0xo<T> X0o0xo(@OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, @OOXIXo Duration duration) {
        return Oxx0IOOO.OIx00oxx(x0o0xo, oIX0oI(duration));
    }

    @oOoXoXO
    public static final <T> Object XO(@OOXIXo Duration duration, @OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return TimeoutKt.I0Io(oIX0oI(duration), x0xo0oo, i0Io);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r0 < 807000000) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long oIX0oI(java.time.Duration r5) {
        /*
            java.time.Duration r0 = OoI0OO.oIX0oI.oIX0oI()
            int r0 = OoI0OO.II0xO0.oIX0oI(r5, r0)
            if (r0 > 0) goto Ld
            r0 = 0
            return r0
        Ld:
            java.time.temporal.ChronoUnit r0 = OoI0OO.I0Io.oIX0oI()
            java.time.Duration r0 = OoI0OO.oxoX.oIX0oI(r0)
            int r0 = OoI0OO.II0xO0.oIX0oI(r5, r0)
            if (r0 > 0) goto L1e
            r0 = 1
            return r0
        L1e:
            long r0 = XoOOx0IX.oIX0oI.oIX0oI(r5)
            r2 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L43
            long r0 = XoOOx0IX.oIX0oI.oIX0oI(r5)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L3d
            int r0 = XoOOx0IX.II0xO0.oIX0oI(r5)
            r1 = 807000000(0x3019d7c0, float:5.5967675E-10)
            if (r0 >= r1) goto L3d
            goto L43
        L3d:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L47
        L43:
            long r0 = OoI0OO.X0o0xo.oIX0oI(r5)
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: OoI0OO.XO.oIX0oI(java.time.Duration):long");
    }

    public static final <R> void oxoX(@OOXIXo kotlinx.coroutines.selects.II0xO0<? super R> iI0xO0, @OOXIXo Duration duration, @OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
        kotlinx.coroutines.selects.oIX0oI.oIX0oI(iI0xO0, oIX0oI(duration), oooxoxo);
    }
}
