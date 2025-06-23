package kotlinx.coroutines.flow;

import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class ooOOo0oXI<T> extends AbstractFlow<T> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<XO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30208XO;

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI(@OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        this.f30208XO = x0xo0oo;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object invoke = this.f30208XO.invoke(xo2, i0Io);
        if (invoke == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return invoke;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
