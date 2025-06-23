package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ ooOOo0oXI<T> $collector;
    final /* synthetic */ kotlinx.coroutines.flow.X0o0xo<T> $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, ooOOo0oXI<T> ooooo0oxi, kotlin.coroutines.I0Io<? super ChannelLimitedFlowMerge$collectTo$2$1> i0Io) {
        super(2, i0Io);
        this.$flow = x0o0xo;
        this.$collector = ooooo0oxi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            kotlinx.coroutines.flow.X0o0xo<T> x0o0xo = this.$flow;
            Object obj2 = this.$collector;
            this.label = 1;
            if (x0o0xo.collect(obj2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
