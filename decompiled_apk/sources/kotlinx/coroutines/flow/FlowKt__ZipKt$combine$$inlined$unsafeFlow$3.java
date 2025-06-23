package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n289#2,5:114\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3<R> implements X0o0xo<R> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.x0xO0oo f30109Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ X0o0xo[] f30110XO;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(X0o0xo[] x0o0xoArr, Oox.x0xO0oo x0xo0oo) {
        this.f30110XO = x0o0xoArr;
        this.f30109Oo = x0xo0oo;
    }

    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.this.collect(null, this);
            }
        };
        xxX.X0o0xo(5);
        X0o0xo[] x0o0xoArr = this.f30110XO;
        IIX0o.xoXoI();
        FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new FlowKt__ZipKt$combine$6$1(this.f30110XO);
        IIX0o.xoXoI();
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.f30109Oo, null);
        xxX.X0o0xo(0);
        CombineKt.oIX0oI(xo2, x0o0xoArr, flowKt__ZipKt$combine$6$1, flowKt__ZipKt$combine$6$2, i0Io);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        X0o0xo[] x0o0xoArr = this.f30110XO;
        IIX0o.xoXoI();
        FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new FlowKt__ZipKt$combine$6$1(this.f30110XO);
        IIX0o.xoXoI();
        Object oIX0oI2 = CombineKt.oIX0oI(xo2, x0o0xoArr, flowKt__ZipKt$combine$6$1, new FlowKt__ZipKt$combine$6$2(this.f30109Oo, null), i0Io);
        if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oIX0oI2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
