package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.IXxxXO;

/* loaded from: classes6.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final kotlinx.coroutines.flow.X0o0xo<S> f30164Oxx0xo;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends S> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f30164Oxx0xo = x0o0xo;
    }

    public static /* synthetic */ <S, T> Object oO(ChannelFlowOperator<S, T> channelFlowOperator, kotlinx.coroutines.flow.XO<? super T> xo2, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (channelFlowOperator.f30156Oo == -3) {
            CoroutineContext context = i0Io.getContext();
            CoroutineContext oxoX2 = CoroutineContextKt.oxoX(context, channelFlowOperator.f30157XO);
            if (IIX0o.Oxx0IOOO(oxoX2, context)) {
                Object IXxxXO2 = channelFlowOperator.IXxxXO(xo2, i0Io);
                if (IXxxXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return IXxxXO2;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
            oxoX.II0xO0 iI0xO0 = kotlin.coroutines.oxoX.f29196Oxx0IOOO;
            if (IIX0o.Oxx0IOOO(oxoX2.get(iI0xO0), context.get(iI0xO0))) {
                Object Oo2 = channelFlowOperator.Oo(xo2, oxoX2, i0Io);
                if (Oo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return Oo2;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        }
        Object collect = super.collect(xo2, i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public static /* synthetic */ <S, T> Object x0xO0oo(ChannelFlowOperator<S, T> channelFlowOperator, IXxxXO<? super T> iXxxXO, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object IXxxXO2 = channelFlowOperator.IXxxXO(new ooOOo0oXI(iXxxXO), i0Io);
        if (IXxxXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return IXxxXO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.oOoXoXO
    public Object II0XooXoX(@OXOo.OOXIXo IXxxXO<? super T> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return x0xO0oo(this, iXxxXO, i0Io);
    }

    @OXOo.oOoXoXO
    public abstract Object IXxxXO(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io);

    public final Object Oo(kotlinx.coroutines.flow.XO<? super T> xo2, CoroutineContext coroutineContext, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object oxoX2 = oxoX.oxoX(coroutineContext, oxoX.oIX0oI(xo2, i0Io.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), i0Io, 4, null);
        if (oxoX2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oxoX2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return oO(this, xo2, i0Io);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public String toString() {
        return this.f30164Oxx0xo + org.apache.commons.text.oIX0oI.f33048oxoX + super.toString();
    }
}
