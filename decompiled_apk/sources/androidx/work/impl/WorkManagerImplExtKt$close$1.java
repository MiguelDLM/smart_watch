package androidx.work.impl;

import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.IIX0;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "androidx.work.impl.WorkManagerImplExtKt$close$1", f = "WorkManagerImplExt.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class WorkManagerImplExtKt$close$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ WorkManagerImpl $this_close;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkManagerImplExtKt$close$1(WorkManagerImpl workManagerImpl, kotlin.coroutines.I0Io<? super WorkManagerImplExtKt$close$1> i0Io) {
        super(2, i0Io);
        this.$this_close = workManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(Object obj, kotlin.coroutines.I0Io<?> i0Io) {
        return new WorkManagerImplExtKt$close$1(this.$this_close, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            CoroutineContext.oIX0oI oix0oi = this.$this_close.getWorkManagerScope().getCoroutineContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO);
            IIX0o.ooOOo0oXI(oix0oi);
            this.label = 1;
            if (IIX0.oOoXoXO((kotlinx.coroutines.oXIO0o0XI) oix0oi, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(xII xii, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((WorkManagerImplExtKt$close$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
