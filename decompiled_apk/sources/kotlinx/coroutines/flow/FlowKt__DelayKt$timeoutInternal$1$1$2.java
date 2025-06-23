package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.TimeoutCancellationException;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$timeoutInternal$1$1$2 extends SuspendLambda implements Oox.oOoXoXO<kotlin.coroutines.I0Io<?>, Object> {
    final /* synthetic */ long $timeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$timeoutInternal$1$1$2(long j, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$timeoutInternal$1$1$2> i0Io) {
        super(1, i0Io);
        this.$timeout = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new FlowKt__DelayKt$timeoutInternal$1$1$2(this.$timeout, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        I0oOoX.x0XOIxOo(obj);
        throw new TimeoutCancellationException("Timed out waiting for " + ((Object) kotlin.time.oxoX.o0xxxXXxX(this.$timeout)));
    }

    @Override // Oox.oOoXoXO
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.oOoXoXO kotlin.coroutines.I0Io<?> i0Io) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$2) create(i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
