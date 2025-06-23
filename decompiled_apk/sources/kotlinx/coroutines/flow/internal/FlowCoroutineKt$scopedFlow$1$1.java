package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ IXxxXO<xII, kotlinx.coroutines.flow.XO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $block;
    final /* synthetic */ kotlinx.coroutines.flow.XO<R> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowCoroutineKt$scopedFlow$1$1(IXxxXO<? super xII, ? super kotlinx.coroutines.flow.XO<? super R>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, kotlinx.coroutines.flow.XO<? super R> xo2, kotlin.coroutines.I0Io<? super FlowCoroutineKt$scopedFlow$1$1> i0Io) {
        super(2, i0Io);
        this.$block = iXxxXO;
        this.$this_unsafeFlow = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, i0Io);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
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
            xII xii = (xII) this.L$0;
            IXxxXO<xII, kotlinx.coroutines.flow.XO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> iXxxXO = this.$block;
            Object obj2 = this.$this_unsafeFlow;
            this.label = 1;
            if (iXxxXO.invoke(xii, obj2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
