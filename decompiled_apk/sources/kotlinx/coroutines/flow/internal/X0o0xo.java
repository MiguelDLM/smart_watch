package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes6.dex */
public final class X0o0xo<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ X0o0xo(kotlinx.coroutines.flow.X0o0xo x0o0xo, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, IIXOooo iIXOooo) {
        this(x0o0xo, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @OXOo.oOoXoXO
    public Object IXxxXO(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = this.f30164Oxx0xo.collect(xo2, i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public kotlinx.coroutines.flow.X0o0xo<T> xoIox() {
        return (kotlinx.coroutines.flow.X0o0xo<T>) this.f30164Oxx0xo;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ChannelFlow<T> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return new X0o0xo(this.f30164Oxx0xo, coroutineContext, i, bufferOverflow);
    }

    public X0o0xo(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(x0o0xo, coroutineContext, i, bufferOverflow);
    }
}
