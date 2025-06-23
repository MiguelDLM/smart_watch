package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.oXIO0o0XI;

@kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@OX00O0xII
/* loaded from: classes6.dex */
public interface o00 extends oXIO0o0XI {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OXOo.oOoXoXO
        public static <E extends CoroutineContext.oIX0oI> E I0Io(@OXOo.OOXIXo o00 o00Var, @OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
            return (E) oXIO0o0XI.oIX0oI.X0o0xo(o00Var, iI0xO0);
        }

        public static <R> R II0xO0(@OXOo.OOXIXo o00 o00Var, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
            return (R) oXIO0o0XI.oIX0oI.oxoX(o00Var, r, x0xo0oo);
        }

        @OXOo.OOXIXo
        public static CoroutineContext X0o0xo(@OXOo.OOXIXo o00 o00Var, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return oXIO0o0XI.oIX0oI.xxIXOIIO(o00Var, coroutineContext);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @OXOo.OOXIXo
        public static oXIO0o0XI XO(@OXOo.OOXIXo o00 o00Var, @OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
            return oXIO0o0XI.oIX0oI.xoIox(o00Var, oxio0o0xi);
        }

        @OXOo.OOXIXo
        public static CoroutineContext oxoX(@OXOo.OOXIXo o00 o00Var, @OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
            return oXIO0o0XI.oIX0oI.II0XooXoX(o00Var, iI0xO0);
        }
    }

    @OX00O0xII
    void Oxx0IOOO(@OXOo.OOXIXo oOoIIO0 oooiio0);
}
