package kotlinx.coroutines.flow;

import com.garmin.fit.X0xOO;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", i = {}, l = {X0xOO.f13593OIxOX}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n18#2:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n*L\n299#1:416\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements Oox.x0xO0oo<oXIO0o0XI, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ XO<T> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$1$2(Ref.ObjectRef<Object> objectRef, XO<? super T> xo2, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$sample$2$1$2> i0Io) {
        super(2, i0Io);
        this.$lastValue = objectRef;
        this.$downstream = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, i0Io);
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
            Ref.ObjectRef<Object> objectRef = this.$lastValue;
            Object obj2 = objectRef.element;
            if (obj2 == null) {
                return oXIO0o0XI.f29392oIX0oI;
            }
            objectRef.element = null;
            XO<T> xo2 = this.$downstream;
            if (obj2 == kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI) {
                obj2 = null;
            }
            this.label = 1;
            if (xo2.emit(obj2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__DelayKt$sample$2$1$2) create(oxio0o0xi, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
