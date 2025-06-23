package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class XO implements CoroutineContext {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f30190Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Throwable f30191XO;

    public XO(@OXOo.OOXIXo Throwable th, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        this.f30191XO = th;
        this.f30190Oo = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OXOo.OOXIXo x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return (R) this.f30190Oo.fold(r, x0xo0oo);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return (E) this.f30190Oo.get(iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext minusKey(@OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return this.f30190Oo.minusKey(iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext plus(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return this.f30190Oo.plus(coroutineContext);
    }
}
