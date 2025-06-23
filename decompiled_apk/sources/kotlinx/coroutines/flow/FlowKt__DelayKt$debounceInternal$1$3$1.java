package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.internal.x0o;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n18#2:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n*L\n232#1:416\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Oox.oOoXoXO<kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ XO<T> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$1(XO<? super T> xo2, Ref.ObjectRef<Object> objectRef, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$debounceInternal$1$3$1> i0Io) {
        super(1, i0Io);
        this.$downstream = xo2;
        this.$lastValue = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, i0Io);
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
            XO<T> xo2 = this.$downstream;
            x0o x0oVar = kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
            Object obj2 = this.$lastValue.element;
            if (obj2 == x0oVar) {
                obj2 = null;
            }
            this.label = 1;
            if (xo2.emit(obj2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        this.$lastValue.element = null;
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.oOoXoXO
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
