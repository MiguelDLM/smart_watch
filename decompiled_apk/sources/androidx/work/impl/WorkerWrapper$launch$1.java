package androidx.work.impl;

import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.I0oOoX;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.XI0IXoo;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "androidx.work.impl.WorkerWrapper$launch$1", f = "WorkerWrapper.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nWorkerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper$launch$1\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,607:1\n32#2:608\n*S KotlinDebug\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper$launch$1\n*L\n105#1:608\n*E\n"})
/* loaded from: classes.dex */
public final class WorkerWrapper$launch$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1(WorkerWrapper workerWrapper, kotlin.coroutines.I0Io<? super WorkerWrapper$launch$1> i0Io) {
        super(2, i0Io);
        this.this$0 = workerWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean invokeSuspend$lambda$1(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        boolean resetWorkerStatus;
        if (resolution instanceof WorkerWrapper.Resolution.Finished) {
            resetWorkerStatus = workerWrapper.onWorkFinished(((WorkerWrapper.Resolution.Finished) resolution).getResult());
        } else if (resolution instanceof WorkerWrapper.Resolution.Failed) {
            workerWrapper.setFailed(((WorkerWrapper.Resolution.Failed) resolution).getResult());
            resetWorkerStatus = false;
        } else if (resolution instanceof WorkerWrapper.Resolution.ResetWorkerStatus) {
            resetWorkerStatus = workerWrapper.resetWorkerStatus(((WorkerWrapper.Resolution.ResetWorkerStatus) resolution).getReason());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Boolean.valueOf(resetWorkerStatus);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(Object obj, kotlin.coroutines.I0Io<?> i0Io) {
        return new WorkerWrapper$launch$1(this.this$0, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        final WorkerWrapper.Resolution failed;
        WorkDatabase workDatabase;
        XI0IXoo xI0IXoo;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    I0oOoX.x0XOIxOo(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                xI0IXoo = this.this$0.workerJob;
                WorkerWrapper$launch$1$resolution$1 workerWrapper$launch$1$resolution$1 = new WorkerWrapper$launch$1$resolution$1(this.this$0, null);
                this.label = 1;
                obj = kotlinx.coroutines.II0XooXoX.II0XooXoX(xI0IXoo, workerWrapper$launch$1$resolution$1, this);
                if (obj == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            failed = (WorkerWrapper.Resolution) obj;
        } catch (WorkerStoppedException e) {
            failed = new WorkerWrapper.Resolution.ResetWorkerStatus(e.getReason());
        } catch (CancellationException unused) {
            failed = new WorkerWrapper.Resolution.Failed(null, 1, null);
        } catch (Throwable th) {
            str = WorkerWrapperKt.TAG;
            Logger.get().error(str, "Unexpected error in WorkerWrapper", th);
            failed = new WorkerWrapper.Resolution.Failed(null, 1, null);
        }
        workDatabase = this.this$0.workDatabase;
        final WorkerWrapper workerWrapper = this.this$0;
        Object runInTransaction = workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.IXxxXO
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = WorkerWrapper$launch$1.invokeSuspend$lambda$1(WorkerWrapper.Resolution.this, workerWrapper);
                return invokeSuspend$lambda$1;
            }
        });
        IIX0o.oO(runInTransaction, "workDatabase.runInTransa…          }\n            )");
        return runInTransaction;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(xII xii, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return ((WorkerWrapper$launch$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
