package kotlinx.coroutines.flow;

import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class CancellableFlowImpl<T> implements oIX0oI<T> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0o0xo<T> f29956XO;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        this.f29956XO = x0o0xo;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = this.f29956XO.collect(new CancellableFlowImpl$collect$2(xo2), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
