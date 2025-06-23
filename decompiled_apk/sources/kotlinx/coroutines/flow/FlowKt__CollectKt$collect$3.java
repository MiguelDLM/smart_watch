package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n*L\n1#1,118:1\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__CollectKt$collect$3<T> implements XO<T> {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f29977XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collect$3(Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        this.f29977XO = x0xo0oo;
    }

    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object invoke = this.f29977XO.invoke(t, i0Io);
        if (invoke == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return invoke;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public Object oIX0oI(T t, @OXOo.OOXIXo final kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__CollectKt$collect$3.this.emit(null, this);
            }
        };
        xxX.X0o0xo(5);
        this.f29977XO.invoke(t, i0Io);
        return oXIO0o0XI.f29392oIX0oI;
    }
}
