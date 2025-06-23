package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.xoIox;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:427\n1#3:426\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n287#1:416,6\n288#1:422,4\n288#1:427\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.channels.xoIox<? extends Object>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<oXIO0o0XI> $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> objectRef, ReceiveChannel<oXIO0o0XI> receiveChannel, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$sample$2$1$1> i0Io) {
        super(2, i0Io);
        this.$lastValue = objectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, i0Io);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.xoIox<? extends Object> xoiox, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return m299invokeWpGqRn0(xoiox.oO(), i0Io);
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m299invokeWpGqRn0(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(kotlinx.coroutines.channels.xoIox.II0xO0(obj), i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, kotlinx.coroutines.internal.x0o] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            ?? oO2 = ((kotlinx.coroutines.channels.xoIox) this.L$0).oO();
            Ref.ObjectRef<Object> objectRef = this.$lastValue;
            boolean z = oO2 instanceof xoIox.I0Io;
            if (!z) {
                objectRef.element = oO2;
            }
            ReceiveChannel<oXIO0o0XI> receiveChannel = this.$ticker;
            if (z) {
                Throwable XO2 = kotlinx.coroutines.channels.xoIox.XO(oO2);
                if (XO2 == null) {
                    receiveChannel.II0xO0(new ChildCancelledException());
                    objectRef.element = kotlinx.coroutines.flow.internal.oOoXoXO.f30196I0Io;
                } else {
                    throw XO2;
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
