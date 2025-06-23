package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class oOoXoXO<T> implements IIXOooo<T>, oIX0oI<T>, kotlinx.coroutines.flow.internal.xxIXOIIO<T> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ IIXOooo<T> f30206Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final oXIO0o0XI f30207XO;

    /* JADX WARN: Multi-variable type inference failed */
    public oOoXoXO(@OXOo.OOXIXo IIXOooo<? extends T> iIXOooo, @OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        this.f30207XO = oxio0o0xi;
        this.f30206Oo = iIXOooo;
    }

    @Override // kotlinx.coroutines.flow.internal.xxIXOIIO
    @OXOo.OOXIXo
    public X0o0xo<T> X0o0xo(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return xoXoI.oxoX(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return this.f30206Oo.collect(xo2, i0Io);
    }

    @Override // kotlinx.coroutines.flow.IIXOooo
    public T getValue() {
        return this.f30206Oo.getValue();
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo
    @OXOo.OOXIXo
    public List<T> oIX0oI() {
        return this.f30206Oo.oIX0oI();
    }
}
