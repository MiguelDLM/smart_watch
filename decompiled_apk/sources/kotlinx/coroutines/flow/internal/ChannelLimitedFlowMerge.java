package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.xII;

@XX({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1855#2,2:101\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n*L\n95#1:101,2\n*E\n"})
/* loaded from: classes6.dex */
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Iterable<kotlinx.coroutines.flow.X0o0xo<T>> f30170Oxx0xo;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, IIXOooo iIXOooo) {
        this(iterable, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.oOoXoXO
    public Object II0XooXoX(@OXOo.OOXIXo IXxxXO<? super T> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        ooOOo0oXI ooooo0oxi = new ooOOo0oXI(iXxxXO);
        Iterator<kotlinx.coroutines.flow.X0o0xo<T>> it = this.f30170Oxx0xo.iterator();
        while (it.hasNext()) {
            kotlinx.coroutines.xoIox.XO(iXxxXO, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(it.next(), ooooo0oxi, null), 3, null);
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ReceiveChannel<T> ooOOo0oXI(@OXOo.OOXIXo xII xii) {
        return ProduceKt.I0Io(xii, this.f30157XO, this.f30156Oo, OOXIXo());
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ChannelFlow<T> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f30170Oxx0xo, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(@OXOo.OOXIXo Iterable<? extends kotlinx.coroutines.flow.X0o0xo<? extends T>> iterable, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f30170Oxx0xo = iterable;
    }
}
