package kotlinx.coroutines.selects;

import Oox.x0xO0oo;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlinx.coroutines.XI0oooXX;

/* loaded from: classes6.dex */
public interface II0xO0<R> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @XX(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
        @xx0o0O.II0XooXoX
        @XI0oooXX
        public static <R> void II0xO0(@OXOo.OOXIXo II0xO0<? super R> iI0xO0, long j, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
            kotlinx.coroutines.selects.oIX0oI.oIX0oI(iI0xO0, j, oooxoxo);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void oIX0oI(@OXOo.OOXIXo II0xO0<? super R> iI0xO0, @OXOo.OOXIXo Oxx0IOOO<? super P, ? extends Q> oxx0IOOO, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
            iI0xO0.I0Io(oxx0IOOO, null, x0xo0oo);
        }
    }

    <P, Q> void I0Io(@OXOo.OOXIXo Oxx0IOOO<? super P, ? extends Q> oxx0IOOO, P p, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo);

    <P, Q> void II0XooXoX(@OXOo.OOXIXo Oxx0IOOO<? super P, ? extends Q> oxx0IOOO, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo);

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @XX(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @xx0o0O.II0XooXoX
    @XI0oooXX
    void X0o0xo(long j, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo);

    <Q> void oIX0oI(@OXOo.OOXIXo X0o0xo<? extends Q> x0o0xo, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo);

    void oxoX(@OXOo.OOXIXo I0Io i0Io, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo);
}
