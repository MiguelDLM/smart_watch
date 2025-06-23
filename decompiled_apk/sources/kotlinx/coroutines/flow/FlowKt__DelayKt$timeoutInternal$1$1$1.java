package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {404}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,415:1\n514#2,6:416\n548#2,5:422\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n403#1:416,6\n405#1:422,5\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.channels.xoIox<? extends T>, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    final /* synthetic */ XO<T> $downStream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$timeoutInternal$1$1$1(XO<? super T> xo2, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$timeoutInternal$1$1$1> i0Io) {
        super(2, i0Io);
        this.$downStream = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, i0Io);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return m300invokeWpGqRn0(((kotlinx.coroutines.channels.xoIox) obj).oO(), i0Io);
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m300invokeWpGqRn0(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(kotlinx.coroutines.channels.xoIox.II0xO0(obj), i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            java.lang.Object r0 = r4.L$0
            kotlin.I0oOoX.x0XOIxOo(r5)
            goto L36
        L11:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L19:
            kotlin.I0oOoX.x0XOIxOo(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.channels.xoIox r5 = (kotlinx.coroutines.channels.xoIox) r5
            java.lang.Object r5 = r5.oO()
            kotlinx.coroutines.flow.XO<T> r1 = r4.$downStream
            boolean r3 = r5 instanceof kotlinx.coroutines.channels.xoIox.I0Io
            if (r3 != 0) goto L37
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r1 = r1.emit(r5, r4)
            if (r1 != r0) goto L35
            return r0
        L35:
            r0 = r5
        L36:
            r5 = r0
        L37:
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.xoIox.oIX0oI
            if (r0 == 0) goto L45
            kotlinx.coroutines.channels.xoIox.XO(r5)
            r5 = 0
            java.lang.Boolean r5 = IXIxx0.oIX0oI.oIX0oI(r5)
            return r5
        L45:
            java.lang.Boolean r5 = IXIxx0.oIX0oI.oIX0oI(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
