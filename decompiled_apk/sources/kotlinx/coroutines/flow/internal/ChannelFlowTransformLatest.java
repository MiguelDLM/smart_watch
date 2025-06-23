package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.x0o;

@XX({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
/* loaded from: classes6.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IXxxXO<kotlinx.coroutines.flow.XO<? super R>, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30165oI0IIXIo;

    public /* synthetic */ ChannelFlowTransformLatest(IXxxXO iXxxXO, kotlinx.coroutines.flow.X0o0xo x0o0xo, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, IIXOooo iIXOooo) {
        this(iXxxXO, x0o0xo, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @OXOo.oOoXoXO
    public Object IXxxXO(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object Oxx0IOOO2 = x0o.Oxx0IOOO(new ChannelFlowTransformLatest$flowCollect$3(this, xo2, null), i0Io);
        if (Oxx0IOOO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return Oxx0IOOO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ChannelFlow<R> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f30165oI0IIXIo, this.f30164Oxx0xo, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@OXOo.OOXIXo IXxxXO<? super kotlinx.coroutines.flow.XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, @OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(x0o0xo, coroutineContext, i, bufferOverflow);
        this.f30165oI0IIXIo = iXxxXO;
    }
}
