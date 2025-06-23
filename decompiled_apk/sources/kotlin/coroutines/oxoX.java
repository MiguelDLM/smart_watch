package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public interface oxoX extends CoroutineContext.oIX0oI {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f29196Oxx0IOOO = II0xO0.f29197XO;

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements CoroutineContext.II0xO0<oxoX> {

        /* renamed from: XO, reason: collision with root package name */
        public static final /* synthetic */ II0xO0 f29197XO = new II0xO0();
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OOXIXo
        public static CoroutineContext I0Io(@OOXIXo oxoX oxox, @OOXIXo CoroutineContext.II0xO0<?> key) {
            IIX0o.x0xO0oo(key, "key");
            if (key instanceof kotlin.coroutines.II0xO0) {
                kotlin.coroutines.II0xO0 iI0xO0 = (kotlin.coroutines.II0xO0) key;
                if (iI0xO0.oIX0oI(oxox.getKey()) && iI0xO0.II0xO0(oxox) != null) {
                    return EmptyCoroutineContext.INSTANCE;
                }
                return oxox;
            }
            if (oxoX.f29196Oxx0IOOO == key) {
                return EmptyCoroutineContext.INSTANCE;
            }
            return oxox;
        }

        @oOoXoXO
        public static <E extends CoroutineContext.oIX0oI> E II0xO0(@OOXIXo oxoX oxox, @OOXIXo CoroutineContext.II0xO0<E> key) {
            IIX0o.x0xO0oo(key, "key");
            if (key instanceof kotlin.coroutines.II0xO0) {
                kotlin.coroutines.II0xO0 iI0xO0 = (kotlin.coroutines.II0xO0) key;
                if (!iI0xO0.oIX0oI(oxox.getKey())) {
                    return null;
                }
                E e = (E) iI0xO0.II0xO0(oxox);
                if (!(e instanceof CoroutineContext.oIX0oI)) {
                    return null;
                }
                return e;
            }
            if (oxoX.f29196Oxx0IOOO != key) {
                return null;
            }
            IIX0o.x0XOIxOo(oxox, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return oxox;
        }

        public static void X0o0xo(@OOXIXo oxoX oxox, @OOXIXo I0Io<?> continuation) {
            IIX0o.x0xO0oo(continuation, "continuation");
        }

        public static <R> R oIX0oI(@OOXIXo oxoX oxox, R r, @OOXIXo x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> operation) {
            IIX0o.x0xO0oo(operation, "operation");
            return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(oxox, r, operation);
        }

        @OOXIXo
        public static CoroutineContext oxoX(@OOXIXo oxoX oxox, @OOXIXo CoroutineContext context) {
            IIX0o.x0xO0oo(context, "context");
            return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(oxox, context);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @oOoXoXO
    <E extends CoroutineContext.oIX0oI> E get(@OOXIXo CoroutineContext.II0xO0<E> iI0xO0);

    @OOXIXo
    <T> I0Io<T> interceptContinuation(@OOXIXo I0Io<? super T> i0Io);

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OOXIXo
    CoroutineContext minusKey(@OOXIXo CoroutineContext.II0xO0<?> iI0xO0);

    void releaseInterceptedContinuation(@OOXIXo I0Io<?> i0Io);
}
