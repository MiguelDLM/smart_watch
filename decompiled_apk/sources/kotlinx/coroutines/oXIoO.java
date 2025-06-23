package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class oXIoO implements CoroutineContext.oIX0oI, CoroutineContext.II0xO0<oXIoO> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oXIoO f30345XO = new oXIoO();

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(this, r, x0xo0oo);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return (E) CoroutineContext.oIX0oI.C1106oIX0oI.II0xO0(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI
    @OXOo.OOXIXo
    public CoroutineContext.II0xO0<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext minusKey(@OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return CoroutineContext.oIX0oI.C1106oIX0oI.I0Io(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext plus(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(this, coroutineContext);
    }
}
