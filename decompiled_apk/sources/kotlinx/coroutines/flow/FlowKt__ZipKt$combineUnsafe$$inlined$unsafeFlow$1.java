package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n262#2,2:114\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1<R> implements X0o0xo<R> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.x0xO0oo f30111Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ X0o0xo[] f30112XO;

    public FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(X0o0xo[] x0o0xoArr, Oox.x0xO0oo x0xo0oo) {
        this.f30112XO = x0o0xoArr;
        this.f30111Oo = x0xo0oo;
    }

    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.this.collect(null, this);
            }
        };
        xxX.X0o0xo(5);
        X0o0xo[] x0o0xoArr = this.f30112XO;
        Oox.oIX0oI oIX0oI2 = FlowKt__ZipKt.oIX0oI();
        IIX0o.xoXoI();
        FlowKt__ZipKt$combineUnsafe$1$1 flowKt__ZipKt$combineUnsafe$1$1 = new FlowKt__ZipKt$combineUnsafe$1$1(this.f30111Oo, null);
        xxX.X0o0xo(0);
        CombineKt.oIX0oI(xo2, x0o0xoArr, oIX0oI2, flowKt__ZipKt$combineUnsafe$1$1, i0Io);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        X0o0xo[] x0o0xoArr = this.f30112XO;
        Oox.oIX0oI oIX0oI2 = FlowKt__ZipKt.oIX0oI();
        IIX0o.xoXoI();
        Object oIX0oI3 = CombineKt.oIX0oI(xo2, x0o0xoArr, oIX0oI2, new FlowKt__ZipKt$combineUnsafe$1$1(this.f30111Oo, null), i0Io);
        if (oIX0oI3 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oIX0oI3;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
