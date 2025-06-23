package kotlinx.coroutines.flow.internal;

import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.channels.oI0IIXIo;

@OX00O0xII
/* loaded from: classes6.dex */
public final class ooOOo0oXI<T> implements kotlinx.coroutines.flow.XO<T> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oI0IIXIo<T> f30199XO;

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI(@OXOo.OOXIXo oI0IIXIo<? super T> oi0iixio) {
        this.f30199XO = oi0iixio;
    }

    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object XOxIOxOx2 = this.f30199XO.XOxIOxOx(t, i0Io);
        if (XOxIOxOx2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return XOxIOxOx2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
