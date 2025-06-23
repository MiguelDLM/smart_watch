package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public interface I0oOoX<T> extends oXIO0o0XI {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OXOo.oOoXoXO
        public static <T, E extends CoroutineContext.oIX0oI> E I0Io(@OXOo.OOXIXo I0oOoX<? extends T> i0oOoX, @OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
            return (E) oXIO0o0XI.oIX0oI.X0o0xo(i0oOoX, iI0xO0);
        }

        public static <T, R> R II0xO0(@OXOo.OOXIXo I0oOoX<? extends T> i0oOoX, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
            return (R) oXIO0o0XI.oIX0oI.oxoX(i0oOoX, r, x0xo0oo);
        }

        @OXOo.OOXIXo
        public static <T> CoroutineContext X0o0xo(@OXOo.OOXIXo I0oOoX<? extends T> i0oOoX, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return oXIO0o0XI.oIX0oI.xxIXOIIO(i0oOoX, coroutineContext);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @OXOo.OOXIXo
        public static <T> oXIO0o0XI XO(@OXOo.OOXIXo I0oOoX<? extends T> i0oOoX, @OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
            return oXIO0o0XI.oIX0oI.xoIox(i0oOoX, oxio0o0xi);
        }

        @OXOo.OOXIXo
        public static <T> CoroutineContext oxoX(@OXOo.OOXIXo I0oOoX<? extends T> i0oOoX, @OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
            return oXIO0o0XI.oIX0oI.II0XooXoX(i0oOoX, iI0xO0);
        }
    }

    @OXOo.oOoXoXO
    @XI0oooXX
    Throwable IIX0o();

    @OXOo.OOXIXo
    kotlinx.coroutines.selects.X0o0xo<T> IoOoX();

    @OXOo.oOoXoXO
    Object XO(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io);

    @XI0oooXX
    T oxoX();
}
