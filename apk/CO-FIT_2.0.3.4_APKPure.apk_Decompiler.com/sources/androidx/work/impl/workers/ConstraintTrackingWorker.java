package androidx.work.impl.workers;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.O00XxXI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@XX({"SMAP\nConstraintTrackingWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintTrackingWorker.kt\nandroidx/work/impl/workers/ConstraintTrackingWorker\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,168:1\n29#2:169\n19#2:170\n19#2:171\n19#2:172\n*S KotlinDebug\n*F\n+ 1 ConstraintTrackingWorker.kt\nandroidx/work/impl/workers/ConstraintTrackingWorker\n*L\n65#1:169\n75#1:170\n78#1:171\n87#1:172\n*E\n"})
public final class ConstraintTrackingWorker extends CoroutineWorker {
    @OOXIXo
    private final WorkerParameters workerParameters;

    public static final class ConstraintUnsatisfiedException extends CancellationException {
        private final int stopReason;

        public ConstraintUnsatisfiedException(int i) {
            this.stopReason = i;
        }

        public final int getStopReason() {
            return this.stopReason;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(@OOXIXo Context context, @OOXIXo WorkerParameters workerParameters2) {
        super(context, workerParameters2);
        IIX0o.x0xO0oo(context, "appContext");
        IIX0o.x0xO0oo(workerParameters2, "workerParameters");
        this.workerParameters = workerParameters2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runWorker(androidx.work.ListenableWorker r5, androidx.work.impl.constraints.WorkConstraintsTracker r6, androidx.work.impl.model.WorkSpec r7, kotlin.coroutines.I0Io<? super androidx.work.ListenableWorker.Result> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1 r0 = (androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1 r0 = new androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.I0oOoX.x0XOIxOo(r8)
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2 r8 = new androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2
            r2 = 0
            r8.<init>(r5, r6, r7, r2)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.x0o.Oxx0IOOO(r8, r0)
            if (r8 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.String r5 = "delegate: ListenableWork….cancel()\n        }\n    }"
            kotlin.jvm.internal.IIX0o.oO(r8, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker.runWorker(androidx.work.ListenableWorker, androidx.work.impl.constraints.WorkConstraintsTracker, androidx.work.impl.model.WorkSpec, kotlin.coroutines.I0Io):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: androidx.work.impl.workers.ConstraintTrackingWorker} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setupAndRunConstraintTrackingWork(kotlin.coroutines.I0Io<? super androidx.work.ListenableWorker.Result> r14) {
        /*
            r13 = this;
            boolean r1 = r14 instanceof androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1
            if (r1 == 0) goto L_0x0014
            r1 = r14
            androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1 r1 = (androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0014
            int r2 = r2 - r3
            r1.label = r2
        L_0x0012:
            r0 = r1
            goto L_0x001a
        L_0x0014:
            androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1 r1 = new androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1
            r1.<init>(r13, r14)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r1 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r8 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r8) goto L_0x0038
            java.lang.Object r2 = r0.L$1
            androidx.work.ListenableWorker r2 = (androidx.work.ListenableWorker) r2
            java.lang.Object r0 = r0.L$0
            r3 = r0
            androidx.work.impl.workers.ConstraintTrackingWorker r3 = (androidx.work.impl.workers.ConstraintTrackingWorker) r3
            kotlin.I0oOoX.x0XOIxOo(r1)     // Catch:{ CancellationException -> 0x0035 }
            goto L_0x0128
        L_0x0035:
            r0 = move-exception
            goto L_0x012e
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            kotlin.I0oOoX.x0XOIxOo(r1)
            androidx.work.Data r1 = r13.getInputData()
            java.lang.String r2 = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME"
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "No worker to delegate to."
            java.lang.String r3 = "failure()"
            if (r1 == 0) goto L_0x019e
            int r4 = r1.length()
            if (r4 != 0) goto L_0x005b
            goto L_0x019e
        L_0x005b:
            android.content.Context r4 = r13.getApplicationContext()
            androidx.work.impl.WorkManagerImpl r4 = androidx.work.impl.WorkManagerImpl.getInstance(r4)
            java.lang.String r5 = "getInstance(applicationContext)"
            kotlin.jvm.internal.IIX0o.oO(r4, r5)
            androidx.work.impl.WorkDatabase r5 = r4.getWorkDatabase()
            androidx.work.impl.model.WorkSpecDao r5 = r5.workSpecDao()
            java.util.UUID r6 = r13.getId()
            java.lang.String r6 = r6.toString()
            java.lang.String r9 = "id.toString()"
            kotlin.jvm.internal.IIX0o.oO(r6, r9)
            androidx.work.impl.model.WorkSpec r5 = r5.getWorkSpec(r6)
            if (r5 != 0) goto L_0x008b
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.IIX0o.oO(r0, r3)
            return r0
        L_0x008b:
            androidx.work.impl.constraints.WorkConstraintsTracker r6 = new androidx.work.impl.constraints.WorkConstraintsTracker
            androidx.work.impl.constraints.trackers.Trackers r9 = r4.getTrackers()
            java.lang.String r10 = "workManagerImpl.trackers"
            kotlin.jvm.internal.IIX0o.oO(r9, r10)
            r6.<init>((androidx.work.impl.constraints.trackers.Trackers) r9)
            boolean r9 = r6.areAllConstraintsMet(r5)
            if (r9 != 0) goto L_0x00cb
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r2 = androidx.work.Logger.get()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Constraints not met for delegate "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ". Requesting retry."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.debug(r0, r1)
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r1 = "retry()"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            return r0
        L_0x00cb:
            java.lang.String r9 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r10 = androidx.work.Logger.get()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Constraints met for delegate "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            r10.debug(r9, r11)
            androidx.work.WorkerFactory r9 = r13.getWorkerFactory()     // Catch:{ all -> 0x0172 }
            android.content.Context r10 = r13.getApplicationContext()     // Catch:{ all -> 0x0172 }
            java.lang.String r11 = "applicationContext"
            kotlin.jvm.internal.IIX0o.oO(r10, r11)     // Catch:{ all -> 0x0172 }
            androidx.work.WorkerParameters r11 = r13.workerParameters     // Catch:{ all -> 0x0172 }
            androidx.work.ListenableWorker r9 = r9.createWorkerWithDefaultFallback(r10, r1, r11)     // Catch:{ all -> 0x0172 }
            androidx.work.WorkerParameters r1 = r13.workerParameters
            androidx.work.impl.utils.taskexecutor.TaskExecutor r1 = r1.getTaskExecutor()
            java.util.concurrent.Executor r1 = r1.getMainThreadExecutor()
            java.lang.String r2 = "workerParameters.taskExecutor.mainThreadExecutor"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.O00XxXI.I0Io(r1)     // Catch:{ CancellationException -> 0x012b }
            androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5 r11 = new androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5     // Catch:{ CancellationException -> 0x012b }
            r12 = 0
            r1 = r11
            r2 = r13
            r3 = r9
            r4 = r6
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ CancellationException -> 0x012b }
            r0.L$0 = r13     // Catch:{ CancellationException -> 0x012b }
            r0.L$1 = r9     // Catch:{ CancellationException -> 0x012b }
            r0.label = r8     // Catch:{ CancellationException -> 0x012b }
            java.lang.Object r1 = kotlinx.coroutines.II0XooXoX.II0XooXoX(r10, r11, r0)     // Catch:{ CancellationException -> 0x012b }
            if (r1 != r7) goto L_0x0126
            return r7
        L_0x0126:
            r3 = r13
            r2 = r9
        L_0x0128:
            androidx.work.ListenableWorker$Result r1 = (androidx.work.ListenableWorker.Result) r1     // Catch:{ CancellationException -> 0x0035 }
            goto L_0x0168
        L_0x012b:
            r0 = move-exception
            r3 = r13
            r2 = r9
        L_0x012e:
            boolean r1 = r3.isStopped()
            if (r1 != 0) goto L_0x0138
            boolean r1 = r0 instanceof androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException
            if (r1 == 0) goto L_0x015a
        L_0x0138:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r1 >= r4) goto L_0x0141
            r1 = -512(0xfffffffffffffe00, float:NaN)
            goto L_0x0157
        L_0x0141:
            boolean r1 = r3.isStopped()
            if (r1 == 0) goto L_0x014c
            int r1 = r3.getStopReason()
            goto L_0x0157
        L_0x014c:
            boolean r1 = r0 instanceof androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException
            if (r1 == 0) goto L_0x016a
            r1 = r0
            androidx.work.impl.workers.ConstraintTrackingWorker$ConstraintUnsatisfiedException r1 = (androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException) r1
            int r1 = r1.getStopReason()
        L_0x0157:
            r2.stop(r1)
        L_0x015a:
            boolean r1 = r0 instanceof androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException
            if (r1 == 0) goto L_0x0169
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r0 = "{\n            // there a…throw cancelled\n        }"
            kotlin.jvm.internal.IIX0o.oO(r1, r0)
        L_0x0168:
            return r1
        L_0x0169:
            throw r0
        L_0x016a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unreachable"
            r0.<init>(r1)
            throw r0
        L_0x0172:
            r0 = move-exception
            java.lang.String r5 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r6 = androidx.work.Logger.get()
            r6.debug(r5, r2)
            androidx.work.Configuration r2 = r4.getConfiguration()
            androidx.core.util.Consumer r2 = r2.getWorkerInitializationExceptionHandler()
            if (r2 == 0) goto L_0x0196
            androidx.work.WorkerExceptionInfo r4 = new androidx.work.WorkerExceptionInfo
            androidx.work.WorkerParameters r5 = r13.workerParameters
            r4.<init>(r1, r5, r0)
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.impl.utils.WorkerExceptionUtilsKt.safeAccept(r2, r4, r0)
        L_0x0196:
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.IIX0o.oO(r0, r3)
            return r0
        L_0x019e:
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r1 = androidx.work.Logger.get()
            r1.error(r0, r2)
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.IIX0o.oO(r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker.setupAndRunConstraintTrackingWork(kotlin.coroutines.I0Io):java.lang.Object");
    }

    @oOoXoXO
    public Object doWork(@OOXIXo I0Io<? super ListenableWorker.Result> i0Io) {
        Executor backgroundExecutor = getBackgroundExecutor();
        IIX0o.oO(backgroundExecutor, "backgroundExecutor");
        return II0XooXoX.II0XooXoX(O00XxXI.I0Io(backgroundExecutor), new ConstraintTrackingWorker$doWork$2(this, (I0Io<? super ConstraintTrackingWorker$doWork$2>) null), i0Io);
    }
}
