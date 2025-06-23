package androidx.work;

import Oox.x0xO0oo;
import androidx.work.ListenableWorker;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class CoroutineWorker$startWork$1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super ListenableWorker.Result>, Object> {
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, kotlin.coroutines.I0Io<? super CoroutineWorker$startWork$1> i0Io) {
        super(2, i0Io);
        this.this$0 = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(Object obj, kotlin.coroutines.I0Io<?> i0Io) {
        return new CoroutineWorker$startWork$1(this.this$0, i0Io);
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
            CoroutineWorker coroutineWorker = this.this$0;
            this.label = 1;
            obj = coroutineWorker.doWork(this);
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return obj;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(xII xii, kotlin.coroutines.I0Io<? super ListenableWorker.Result> i0Io) {
        return ((CoroutineWorker$startWork$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
