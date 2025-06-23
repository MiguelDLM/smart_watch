package kotlinx.coroutines.selects;

import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.XI0oooXX;

/* loaded from: classes6.dex */
public final class oIX0oI {
    @XI0oooXX
    public static final <R> void II0xO0(@OXOo.OOXIXo II0xO0<? super R> iI0xO0, long j, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
        oIX0oI(iI0xO0, DelayKt.X0o0xo(j), oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XI0oooXX
    public static final <R> void oIX0oI(@OXOo.OOXIXo II0xO0<? super R> iI0xO0, long j, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
        iI0xO0.oxoX(new OnTimeout(j).II0xO0(), oooxoxo);
    }
}
