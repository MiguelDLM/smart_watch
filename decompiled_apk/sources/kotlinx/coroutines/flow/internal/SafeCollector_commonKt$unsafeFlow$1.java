package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n*L\n1#1,113:1\n*E\n"})
/* loaded from: classes6.dex */
public final class SafeCollector_commonKt$unsafeFlow$1<T> implements kotlinx.coroutines.flow.X0o0xo<T> {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ x0xO0oo<kotlinx.coroutines.flow.XO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30186XO;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector_commonKt$unsafeFlow$1(x0xO0oo<? super kotlinx.coroutines.flow.XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        this.f30186XO = x0xo0oo;
    }

    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo final kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return SafeCollector_commonKt$unsafeFlow$1.this.collect(null, this);
            }
        };
        xxX.X0o0xo(5);
        this.f30186XO.invoke(xo2, i0Io);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object invoke = this.f30186XO.invoke(xo2, i0Io);
        if (invoke == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return invoke;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
