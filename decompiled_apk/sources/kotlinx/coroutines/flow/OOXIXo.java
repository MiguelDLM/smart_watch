package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class OOXIXo<T> implements x0XOIxOo<T>, oIX0oI<T>, kotlinx.coroutines.flow.internal.xxIXOIIO<T> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ x0XOIxOo<T> f30124Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final oXIO0o0XI f30125XO;

    /* JADX WARN: Multi-variable type inference failed */
    public OOXIXo(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo, @OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        this.f30125XO = oxio0o0xi;
        this.f30124Oo = x0xoixoo;
    }

    @Override // kotlinx.coroutines.flow.internal.xxIXOIIO
    @OXOo.OOXIXo
    public X0o0xo<T> X0o0xo(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return oO.X0o0xo(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return this.f30124Oo.collect(xo2, i0Io);
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo
    @OXOo.OOXIXo
    public List<T> oIX0oI() {
        return this.f30124Oo.oIX0oI();
    }
}
