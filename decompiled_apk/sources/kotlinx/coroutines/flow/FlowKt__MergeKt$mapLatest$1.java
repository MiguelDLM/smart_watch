package kotlinx.coroutines.flow;

import com.jieli.jl_rcsp.constant.Command;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {}, l = {Command.CMD_GET_DEVICE_CONFIG_INFO, Command.CMD_GET_DEVICE_CONFIG_INFO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__MergeKt$mapLatest$1<R, T> extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super FlowKt__MergeKt$mapLatest$1> i0Io) {
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
            XO xo3 = (XO) this.L$0;
            I0oOoX.x0XOIxOo(obj);
            xo2 = xo3;
        } else {
            I0oOoX.x0XOIxOo(obj);
            XO xo4 = (XO) this.L$0;
            Object obj2 = this.L$1;
            Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super R>, Object> x0xo0oo = this.$transform;
            this.L$0 = xo4;
            this.label = 1;
            obj = x0xo0oo.invoke(obj2, this);
            xo2 = xo4;
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (xo2.emit(obj, this) == oOoXoXO2) {
            return oOoXoXO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, T t, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, i0Io);
        flowKt__MergeKt$mapLatest$1.L$0 = xo2;
        flowKt__MergeKt$mapLatest$1.L$1 = t;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
