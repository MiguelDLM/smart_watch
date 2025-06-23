package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.xII;

@XX({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/ChannelAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n1#2:177\n*E\n"})
/* loaded from: classes6.dex */
public final class II0xO0<T> extends ChannelFlow<T> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30117OxxIIOOXO = AtomicIntegerFieldUpdater.newUpdater(II0xO0.class, "consumed");

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ReceiveChannel<T> f30118Oxx0xo;

    @XO0OX.o00
    private volatile int consumed;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final boolean f30119oI0IIXIo;

    public /* synthetic */ II0xO0(ReceiveChannel receiveChannel, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(receiveChannel, z, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 8) != 0 ? -3 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.oOoXoXO
    public Object II0XooXoX(@OXOo.OOXIXo kotlinx.coroutines.channels.IXxxXO<? super T> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object X0o0xo2;
        X0o0xo2 = FlowKt__ChannelsKt.X0o0xo(new kotlinx.coroutines.flow.internal.ooOOo0oXI(iXxxXO), this.f30118Oxx0xo, this.f30119oI0IIXIo, i0Io);
        if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return X0o0xo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public String XO() {
        return "channel=" + this.f30118Oxx0xo;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object X0o0xo2;
        if (this.f30156Oo == -3) {
            x0XOIxOo();
            X0o0xo2 = FlowKt__ChannelsKt.X0o0xo(xo2, this.f30118Oxx0xo, this.f30119oI0IIXIo, i0Io);
            if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return X0o0xo2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        Object collect = super.collect(xo2, i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ReceiveChannel<T> ooOOo0oXI(@OXOo.OOXIXo xII xii) {
        x0XOIxOo();
        if (this.f30156Oo == -3) {
            return this.f30118Oxx0xo;
        }
        return super.ooOOo0oXI(xii);
    }

    public final void x0XOIxOo() {
        if (this.f30119oI0IIXIo && f30117OxxIIOOXO.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public X0o0xo<T> xoIox() {
        return new II0xO0(this.f30118Oxx0xo, this.f30119oI0IIXIo, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ChannelFlow<T> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return new II0xO0(this.f30118Oxx0xo, this.f30119oI0IIXIo, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0xO0(@OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel, boolean z, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f30118Oxx0xo = receiveChannel;
        this.f30119oI0IIXIo = z;
        this.consumed = 0;
    }
}
