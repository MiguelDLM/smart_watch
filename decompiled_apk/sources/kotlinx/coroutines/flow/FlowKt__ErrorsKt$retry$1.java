package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__ErrorsKt$retry$1 extends SuspendLambda implements Oox.x0xO0oo<Throwable, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    int label;

    public FlowKt__ErrorsKt$retry$1(kotlin.coroutines.I0Io<? super FlowKt__ErrorsKt$retry$1> i0Io) {
        super(2, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new FlowKt__ErrorsKt$retry$1(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            return IXIxx0.oIX0oI.oIX0oI(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo Throwable th, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return ((FlowKt__ErrorsKt$retry$1) create(th, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
