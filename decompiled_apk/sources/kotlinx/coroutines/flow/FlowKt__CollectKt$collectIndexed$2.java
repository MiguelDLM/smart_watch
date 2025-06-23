package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,118:1\n32#2,4:119\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n*L\n62#1:119,4\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements XO<T> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.IXxxXO<Integer, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f29978Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int f29979XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collectIndexed$2(Oox.IXxxXO<? super Integer, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        this.f29978Oo = iXxxXO;
    }

    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Oox.IXxxXO<Integer, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> iXxxXO = this.f29978Oo;
        int i = this.f29979XO;
        this.f29979XO = i + 1;
        if (i >= 0) {
            Object invoke = iXxxXO.invoke(IXIxx0.oIX0oI.XO(i), t, i0Io);
            if (invoke == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return invoke;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    @OXOo.oOoXoXO
    public Object oIX0oI(T t, @OXOo.OOXIXo final kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__CollectKt$collectIndexed$2.this.emit(null, this);
            }
        };
        xxX.X0o0xo(5);
        Oox.IXxxXO<Integer, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> iXxxXO = this.f29978Oo;
        int i = this.f29979XO;
        this.f29979XO = i + 1;
        if (i >= 0) {
            iXxxXO.invoke(Integer.valueOf(i), t, i0Io);
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
