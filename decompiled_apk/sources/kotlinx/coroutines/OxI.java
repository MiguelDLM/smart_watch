package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.I0oOoX;

/* loaded from: classes6.dex */
public interface OxI<T> extends I0oOoX<T> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OXOo.oOoXoXO
        public static <T, E extends CoroutineContext.oIX0oI> E I0Io(@OXOo.OOXIXo OxI<T> oxI, @OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
            return (E) I0oOoX.oIX0oI.I0Io(oxI, iI0xO0);
        }

        public static <T, R> R II0xO0(@OXOo.OOXIXo OxI<T> oxI, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
            return (R) I0oOoX.oIX0oI.II0xO0(oxI, r, x0xo0oo);
        }

        @OXOo.OOXIXo
        public static <T> CoroutineContext X0o0xo(@OXOo.OOXIXo OxI<T> oxI, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return I0oOoX.oIX0oI.X0o0xo(oxI, coroutineContext);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @OXOo.OOXIXo
        public static <T> oXIO0o0XI XO(@OXOo.OOXIXo OxI<T> oxI, @OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
            return I0oOoX.oIX0oI.XO(oxI, oxio0o0xi);
        }

        @OXOo.OOXIXo
        public static <T> CoroutineContext oxoX(@OXOo.OOXIXo OxI<T> oxI, @OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
            return I0oOoX.oIX0oI.oxoX(oxI, iI0xO0);
        }
    }

    boolean I0Io(@OXOo.OOXIXo Throwable th);

    boolean oO(T t);
}
