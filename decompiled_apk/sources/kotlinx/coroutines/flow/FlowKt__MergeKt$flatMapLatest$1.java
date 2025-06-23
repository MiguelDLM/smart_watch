package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {193, 193}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__MergeKt$flatMapLatest$1<R, T> extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flatMapLatest$1(Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super FlowKt__MergeKt$flatMapLatest$1> i0Io) {
        super(3, i0Io);
        this.$transform = x0xo0oo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke((XO) obj, (XO<? super R>) obj2, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        XO xo2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    I0oOoX.x0XOIxOo(obj);
                    return oXIO0o0XI.f29392oIX0oI;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            xo2 = (XO) this.L$0;
            I0oOoX.x0XOIxOo(obj);
        } else {
            I0oOoX.x0XOIxOo(obj);
            xo2 = (XO) this.L$0;
            Object obj2 = this.L$1;
            Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, Object> x0xo0oo = this.$transform;
            this.L$0 = xo2;
            this.label = 1;
            obj = x0xo0oo.invoke(obj2, this);
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (Oxx0IOOO.IoOoo(xo2, (X0o0xo) obj, this) == oOoXoXO2) {
            return oOoXoXO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object invokeSuspend$$forInline(@OXOo.OOXIXo Object obj) {
        XO xo2 = (XO) this.L$0;
        X0o0xo x0o0xo = (X0o0xo) this.$transform.invoke(this.L$1, this);
        xxX.X0o0xo(0);
        Oxx0IOOO.IoOoo(xo2, x0o0xo, this);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, T t, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, i0Io);
        flowKt__MergeKt$flatMapLatest$1.L$0 = xo2;
        flowKt__MergeKt$flatMapLatest$1.L$1 = t;
        return flowKt__MergeKt$flatMapLatest$1.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
