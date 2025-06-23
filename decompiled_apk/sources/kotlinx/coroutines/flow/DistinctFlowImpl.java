package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class DistinctFlowImpl<T> implements X0o0xo<T> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Oox.x0xO0oo<Object, Object, Boolean> f29958IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Oox.oOoXoXO<T, Object> f29959Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0o0xo<T> f29960XO;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Object> oooxoxo, @OXOo.OOXIXo Oox.x0xO0oo<Object, Object, Boolean> x0xo0oo) {
        this.f29960XO = x0o0xo;
        this.f29959Oo = oooxoxo;
        this.f29958IXxxXO = x0xo0oo;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
        Object collect = this.f29960XO.collect(new DistinctFlowImpl$collect$2(this, objectRef, xo2), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
