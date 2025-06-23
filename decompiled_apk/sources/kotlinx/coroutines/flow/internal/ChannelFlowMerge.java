package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.coroutines.flow.X0o0xo<kotlinx.coroutines.flow.X0o0xo<T>> f30158Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final int f30159oI0IIXIo;

    public /* synthetic */ ChannelFlowMerge(kotlinx.coroutines.flow.X0o0xo x0o0xo, int i, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, IIXOooo iIXOooo) {
        this(x0o0xo, i, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 8) != 0 ? -2 : i2, (i3 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.oOoXoXO
    public Object II0XooXoX(@OXOo.OOXIXo IXxxXO<? super T> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        kotlinx.coroutines.sync.II0xO0 II0xO02 = SemaphoreKt.II0xO0(this.f30159oI0IIXIo, 0, 2, null);
        ooOOo0oXI ooooo0oxi = new ooOOo0oXI(iXxxXO);
        Object collect = this.f30158Oxx0xo.collect(new ChannelFlowMerge$collectTo$2((kotlinx.coroutines.oXIO0o0XI) i0Io.getContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO), II0xO02, iXxxXO, ooooo0oxi), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public String XO() {
        return "concurrency=" + this.f30159oI0IIXIo;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ReceiveChannel<T> ooOOo0oXI(@OXOo.OOXIXo xII xii) {
        return ProduceKt.I0Io(xii, this.f30157XO, this.f30156Oo, OOXIXo());
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ChannelFlow<T> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.f30158Oxx0xo, this.f30159oI0IIXIo, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends kotlinx.coroutines.flow.X0o0xo<? extends T>> x0o0xo, int i, @OXOo.OOXIXo CoroutineContext coroutineContext, int i2, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f30158Oxx0xo = x0o0xo;
        this.f30159oI0IIXIo = i;
    }
}
