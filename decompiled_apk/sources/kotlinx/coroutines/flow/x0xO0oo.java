package kotlinx.coroutines.flow;

import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: classes6.dex */
public final class x0xO0oo extends kotlinx.coroutines.flow.internal.I0Io<SharedFlowImpl<?>> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public kotlin.coroutines.I0Io<? super oXIO0o0XI> f30210II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @XO0OX.XO
    public long f30211oIX0oI = -1;

    @Override // kotlinx.coroutines.flow.internal.I0Io
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public boolean oIX0oI(@OXOo.OOXIXo SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f30211oIX0oI >= 0) {
            return false;
        }
        this.f30211oIX0oI = sharedFlowImpl.xo0x();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.I0Io
    @OXOo.OOXIXo
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.I0Io<oXIO0o0XI>[] II0xO0(@OXOo.OOXIXo SharedFlowImpl<?> sharedFlowImpl) {
        long j = this.f30211oIX0oI;
        this.f30211oIX0oI = -1L;
        this.f30210II0xO0 = null;
        return sharedFlowImpl.oxXx0IX(j);
    }
}
