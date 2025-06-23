package androidx.work.impl.workers;

import IXIxx0.oxoX;
import Oox.x0xO0oo;
import androidx.work.ListenableWorker;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.work.impl.workers.ConstraintTrackingWorker$doWork$2", f = "ConstraintTrackingWorker.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class ConstraintTrackingWorker$doWork$2 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super ListenableWorker.Result>, Object> {
    int label;
    final /* synthetic */ ConstraintTrackingWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$doWork$2(ConstraintTrackingWorker constraintTrackingWorker, I0Io<? super ConstraintTrackingWorker$doWork$2> i0Io) {
        super(2, i0Io);
        this.this$0 = constraintTrackingWorker;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        return new ConstraintTrackingWorker$doWork$2(this.this$0, i0Io);
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            ConstraintTrackingWorker constraintTrackingWorker = this.this$0;
            this.label = 1;
            obj = constraintTrackingWorker.setupAndRunConstraintTrackingWork(this);
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    public final Object invoke(xII xii, I0Io<? super ListenableWorker.Result> i0Io) {
        return ((ConstraintTrackingWorker$doWork$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
