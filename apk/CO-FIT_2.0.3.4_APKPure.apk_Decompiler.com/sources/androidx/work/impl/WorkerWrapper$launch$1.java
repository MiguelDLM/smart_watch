package androidx.work.impl;

import IXIxx0.oxoX;
import Oox.x0xO0oo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import java.util.concurrent.CancellationException;
import kotlin.I0oOoX;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.XI0IXoo;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.work.impl.WorkerWrapper$launch$1", f = "WorkerWrapper.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nWorkerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper$launch$1\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,607:1\n32#2:608\n*S KotlinDebug\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapper$launch$1\n*L\n105#1:608\n*E\n"})
public final class WorkerWrapper$launch$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super Boolean>, Object> {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1(WorkerWrapper workerWrapper, I0Io<? super WorkerWrapper$launch$1> i0Io) {
        super(2, i0Io);
        this.this$0 = workerWrapper;
    }

    /* access modifiers changed from: private */
    public static final Boolean invokeSuspend$lambda$1(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        boolean z;
        if (resolution instanceof WorkerWrapper.Resolution.Finished) {
            z = workerWrapper.onWorkFinished(((WorkerWrapper.Resolution.Finished) resolution).getResult());
        } else if (resolution instanceof WorkerWrapper.Resolution.Failed) {
            workerWrapper.setFailed(((WorkerWrapper.Resolution.Failed) resolution).getResult());
            z = false;
        } else if (resolution instanceof WorkerWrapper.Resolution.ResetWorkerStatus) {
            z = workerWrapper.resetWorkerStatus(((WorkerWrapper.Resolution.ResetWorkerStatus) resolution).getReason());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Boolean.valueOf(z);
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        return new WorkerWrapper$launch$1(this.this$0, i0Io);
    }

    public final Object invokeSuspend(Object obj) {
        WorkerWrapper.Resolution resolution;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            XI0IXoo access$getWorkerJob$p = this.this$0.workerJob;
            WorkerWrapper$launch$1$resolution$1 workerWrapper$launch$1$resolution$1 = new WorkerWrapper$launch$1$resolution$1(this.this$0, (I0Io<? super WorkerWrapper$launch$1$resolution$1>) null);
            this.label = 1;
            obj = II0XooXoX.II0XooXoX(access$getWorkerJob$p, workerWrapper$launch$1$resolution$1, this);
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            try {
                I0oOoX.x0XOIxOo(obj);
            } catch (WorkerStoppedException e) {
                resolution = new WorkerWrapper.Resolution.ResetWorkerStatus(e.getReason());
            } catch (CancellationException unused) {
                resolution = new WorkerWrapper.Resolution.Failed((ListenableWorker.Result) null, 1, (IIXOooo) null);
            } catch (Throwable th) {
                Logger.get().error(WorkerWrapperKt.TAG, "Unexpected error in WorkerWrapper", th);
                resolution = new WorkerWrapper.Resolution.Failed((ListenableWorker.Result) null, 1, (IIXOooo) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        resolution = (WorkerWrapper.Resolution) obj;
        Object runInTransaction = this.this$0.workDatabase.runInTransaction(new IXxxXO(resolution, this.this$0));
        IIX0o.oO(runInTransaction, "workDatabase.runInTransa…          }\n            )");
        return runInTransaction;
    }

    public final Object invoke(xII xii, I0Io<? super Boolean> i0Io) {
        return ((WorkerWrapper$launch$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
