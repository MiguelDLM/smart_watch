package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes6.dex */
public final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.XO<T> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final x0xO0oo<T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30187IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Object f30188Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext f30189XO;

    public UndispatchedContextCollector(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        this.f30189XO = coroutineContext;
        this.f30188Oo = ThreadContextKt.II0xO0(coroutineContext);
        this.f30187IXxxXO = new UndispatchedContextCollector$emitRef$1(xo2, null);
    }

    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object I0Io2 = oxoX.I0Io(this.f30189XO, t, this.f30188Oo, this.f30187IXxxXO, i0Io);
        if (I0Io2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return I0Io2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
