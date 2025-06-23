package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R] */
@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1<R> implements X0o0xo<R> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.IXxxXO f29994Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ X0o0xo f29995XO;

    public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(X0o0xo x0o0xo, Oox.IXxxXO iXxxXO) {
        this.f29995XO = x0o0xo;
        this.f29994Oo = iXxxXO;
    }

    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.this.collect(null, this);
            }
        };
        xxX.X0o0xo(5);
        X0o0xo x0o0xo = this.f29995XO;
        FlowKt__EmittersKt$unsafeTransform$1$1 flowKt__EmittersKt$unsafeTransform$1$1 = new FlowKt__EmittersKt$unsafeTransform$1$1(this.f29994Oo, xo2);
        xxX.X0o0xo(0);
        x0o0xo.collect(flowKt__EmittersKt$unsafeTransform$1$1, i0Io);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = this.f29995XO.collect(new FlowKt__EmittersKt$unsafeTransform$1$1(this.f29994Oo, xo2), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
