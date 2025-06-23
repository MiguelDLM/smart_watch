package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public interface X0xII0I<S> extends CoroutineContext.oIX0oI {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OXOo.OOXIXo
        public static <S> CoroutineContext I0Io(@OXOo.OOXIXo X0xII0I<S> x0xII0I, @OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
            return CoroutineContext.oIX0oI.C1106oIX0oI.I0Io(x0xII0I, iI0xO0);
        }

        @OXOo.oOoXoXO
        public static <S, E extends CoroutineContext.oIX0oI> E II0xO0(@OXOo.OOXIXo X0xII0I<S> x0xII0I, @OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
            return (E) CoroutineContext.oIX0oI.C1106oIX0oI.II0xO0(x0xII0I, iI0xO0);
        }

        public static <S, R> R oIX0oI(@OXOo.OOXIXo X0xII0I<S> x0xII0I, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
            return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(x0xII0I, r, x0xo0oo);
        }

        @OXOo.OOXIXo
        public static <S> CoroutineContext oxoX(@OXOo.OOXIXo X0xII0I<S> x0xII0I, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(x0xII0I, coroutineContext);
        }
    }

    S Io(@OXOo.OOXIXo CoroutineContext coroutineContext);

    void x0XOIxOo(@OXOo.OOXIXo CoroutineContext coroutineContext, S s);
}
