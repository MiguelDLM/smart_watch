package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public interface oOXoIIIo extends CoroutineContext.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f30339II0XooXoX = II0xO0.f30340XO;

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements CoroutineContext.II0xO0<oOXoIIIo> {

        /* renamed from: XO, reason: collision with root package name */
        public static final /* synthetic */ II0xO0 f30340XO = new II0xO0();
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OXOo.OOXIXo
        public static CoroutineContext I0Io(@OXOo.OOXIXo oOXoIIIo ooxoiiio, @OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
            return CoroutineContext.oIX0oI.C1106oIX0oI.I0Io(ooxoiiio, iI0xO0);
        }

        @OXOo.oOoXoXO
        public static <E extends CoroutineContext.oIX0oI> E II0xO0(@OXOo.OOXIXo oOXoIIIo ooxoiiio, @OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
            return (E) CoroutineContext.oIX0oI.C1106oIX0oI.II0xO0(ooxoiiio, iI0xO0);
        }

        public static <R> R oIX0oI(@OXOo.OOXIXo oOXoIIIo ooxoiiio, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
            return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(ooxoiiio, r, x0xo0oo);
        }

        @OXOo.OOXIXo
        public static CoroutineContext oxoX(@OXOo.OOXIXo oOXoIIIo ooxoiiio, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(ooxoiiio, coroutineContext);
        }
    }

    void IXxxXO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Throwable th);
}
