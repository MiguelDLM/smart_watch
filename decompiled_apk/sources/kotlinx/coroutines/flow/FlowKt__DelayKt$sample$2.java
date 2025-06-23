package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.xII;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {423}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n55#2,8:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n284#1:416,8\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$sample$2<T> extends SuspendLambda implements Oox.IXxxXO<xII, XO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ X0o0xo<T> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2(long j, X0o0xo<? extends T> x0o0xo, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$sample$2> i0Io) {
        super(3, i0Io);
        this.$periodMillis = j;
        this.$this_sample = x0o0xo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        ReceiveChannel Oxx0IOOO2;
        XO xo2;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannel2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                receiveChannel2 = (ReceiveChannel) this.L$3;
                objectRef = (Ref.ObjectRef) this.L$2;
                receiveChannel = (ReceiveChannel) this.L$1;
                xo2 = (XO) this.L$0;
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            xII xii = (xII) this.L$0;
            XO xo3 = (XO) this.L$1;
            ReceiveChannel XO2 = ProduceKt.XO(xii, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Oxx0IOOO2 = FlowKt__DelayKt.Oxx0IOOO(xii, this.$periodMillis, 0L, 2, null);
            xo2 = xo3;
            receiveChannel = XO2;
            objectRef = objectRef2;
            receiveChannel2 = Oxx0IOOO2;
        }
        while (objectRef.element != kotlinx.coroutines.flow.internal.oOoXoXO.f30196I0Io) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.oIX0oI(receiveChannel.Oxx0xo(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannel2, null));
            selectImplementation.oIX0oI(receiveChannel2.Xx000oIo(), new FlowKt__DelayKt$sample$2$1$2(objectRef, xo2, null));
            this.L$0 = xo2;
            this.L$1 = receiveChannel;
            this.L$2 = objectRef;
            this.L$3 = receiveChannel2;
            this.label = 1;
            if (selectImplementation.o00(this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.IXxxXO
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo XO<? super T> xo2, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, i0Io);
        flowKt__DelayKt$sample$2.L$0 = xii;
        flowKt__DelayKt$sample$2.L$1 = xo2;
        return flowKt__DelayKt$sample$2.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
