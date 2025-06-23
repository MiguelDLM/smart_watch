package kotlinx.coroutines.flow;

import com.jieli.jl_rcsp.constant.Command;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.xoIox;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:428\n1#3:426\n18#4:427\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n238#1:416,6\n239#1:422,4\n239#1:428\n242#1:427\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.channels.xoIox<? extends Object>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ XO<T> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> objectRef, XO<? super T> xo2, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$debounceInternal$1$3$2> i0Io) {
        super(2, i0Io);
        this.$lastValue = objectRef;
        this.$downstream = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, i0Io);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.xoIox<? extends Object> xoiox, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return m298invokeWpGqRn0(xoiox.oO(), i0Io);
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m298invokeWpGqRn0(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(kotlinx.coroutines.channels.xoIox.II0xO0(obj), i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, kotlinx.coroutines.internal.x0o] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                objectRef2 = (Ref.ObjectRef) this.L$1;
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            ?? oO2 = ((kotlinx.coroutines.channels.xoIox) this.L$0).oO();
            objectRef = this.$lastValue;
            boolean z = oO2 instanceof xoIox.I0Io;
            if (!z) {
                objectRef.element = oO2;
            }
            XO<T> xo2 = this.$downstream;
            if (z) {
                Throwable XO2 = kotlinx.coroutines.channels.xoIox.XO(oO2);
                if (XO2 == null) {
                    Object obj2 = objectRef.element;
                    if (obj2 != null) {
                        if (obj2 == kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI) {
                            obj2 = null;
                        }
                        this.L$0 = oO2;
                        this.L$1 = objectRef;
                        this.label = 1;
                        if (xo2.emit(obj2, this) == oOoXoXO2) {
                            return oOoXoXO2;
                        }
                        objectRef2 = objectRef;
                    }
                    objectRef.element = kotlinx.coroutines.flow.internal.oOoXoXO.f30196I0Io;
                } else {
                    throw XO2;
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        objectRef = objectRef2;
        objectRef.element = kotlinx.coroutines.flow.internal.oOoXoXO.f30196I0Io;
        return oXIO0o0XI.f29392oIX0oI;
    }
}
