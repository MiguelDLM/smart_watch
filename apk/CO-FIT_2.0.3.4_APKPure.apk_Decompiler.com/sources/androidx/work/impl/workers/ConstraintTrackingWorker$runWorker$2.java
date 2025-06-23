package androidx.work.impl.workers;

import IXIxx0.oxoX;
import Oox.x0xO0oo;
import androidx.work.ListenableWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2", f = "ConstraintTrackingWorker.kt", i = {0, 0, 0}, l = {134}, m = "invokeSuspend", n = {"atomicReason", "future", "constraintTrackingJob"}, s = {"L$0", "L$1", "L$2"})
@XX({"SMAP\nConstraintTrackingWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintTrackingWorker.kt\nandroidx/work/impl/workers/ConstraintTrackingWorker$runWorker$2\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,168:1\n22#2:169\n22#2:170\n*S KotlinDebug\n*F\n+ 1 ConstraintTrackingWorker.kt\nandroidx/work/impl/workers/ConstraintTrackingWorker$runWorker$2\n*L\n137#1:169\n144#1:170\n*E\n"})
public final class ConstraintTrackingWorker$runWorker$2 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super ListenableWorker.Result>, Object> {
    final /* synthetic */ ListenableWorker $delegate;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$runWorker$2(ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, I0Io<? super ConstraintTrackingWorker$runWorker$2> i0Io) {
        super(2, i0Io);
        this.$delegate = listenableWorker;
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        ConstraintTrackingWorker$runWorker$2 constraintTrackingWorker$runWorker$2 = new ConstraintTrackingWorker$runWorker$2(this.$delegate, this.$workConstraintsTracker, this.$workSpec, i0Io);
        constraintTrackingWorker$runWorker$2.L$0 = obj;
        return constraintTrackingWorker$runWorker$2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: kotlinx.coroutines.oXIO0o0XI} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$Result>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.util.concurrent.atomic.AtomicInteger} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d9 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e2 A[ADDED_TO_REGION, Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0028 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v8 kotlinx.coroutines.oXIO0o0XI) = (r2v2 kotlinx.coroutines.oXIO0o0XI), (r2v2 kotlinx.coroutines.oXIO0o0XI), (r2v11 kotlinx.coroutines.oXIO0o0XI), (r2v11 kotlinx.coroutines.oXIO0o0XI) binds: [B:17:0x0075, B:18:?, B:4:0x0021, B:5:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:4:0x0021] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r1.label
            java.lang.String r3 = "Delegated worker "
            r4 = -256(0xffffffffffffff00, float:NaN)
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r6) goto L_0x002d
            java.lang.Object r0 = r1.L$2
            r2 = r0
            kotlinx.coroutines.oXIO0o0XI r2 = (kotlinx.coroutines.oXIO0o0XI) r2
            java.lang.Object r0 = r1.L$1
            r7 = r0
            com.google.common.util.concurrent.ListenableFuture r7 = (com.google.common.util.concurrent.ListenableFuture) r7
            java.lang.Object r0 = r1.L$0
            r8 = r0
            java.util.concurrent.atomic.AtomicInteger r8 = (java.util.concurrent.atomic.AtomicInteger) r8
            kotlin.I0oOoX.x0XOIxOo(r17)     // Catch:{ CancellationException -> 0x002a, all -> 0x0028 }
            r9 = r8
            r8 = r17
            goto L_0x0075
        L_0x0028:
            r0 = move-exception
            goto L_0x0086
        L_0x002a:
            r0 = move-exception
            goto L_0x00ae
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0035:
            kotlin.I0oOoX.x0XOIxOo(r17)
            java.lang.Object r2 = r1.L$0
            r7 = r2
            kotlinx.coroutines.xII r7 = (kotlinx.coroutines.xII) r7
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r4)
            androidx.work.ListenableWorker r8 = r1.$delegate
            com.google.common.util.concurrent.ListenableFuture r14 = r8.startWork()
            java.lang.String r8 = "delegate.startWork()"
            kotlin.jvm.internal.IIX0o.oO(r14, r8)
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1 r15 = new androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1
            androidx.work.impl.constraints.WorkConstraintsTracker r9 = r1.$workConstraintsTracker
            androidx.work.impl.model.WorkSpec r10 = r1.$workSpec
            r13 = 0
            r8 = r15
            r11 = r2
            r12 = r14
            r8.<init>(r9, r10, r11, r12, r13)
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            r10 = r15
            kotlinx.coroutines.oXIO0o0XI r7 = kotlinx.coroutines.xoIox.XO(r7, r8, r9, r10, r11, r12)
            r1.L$0 = r2     // Catch:{ CancellationException -> 0x0081, all -> 0x007e }
            r1.L$1 = r14     // Catch:{ CancellationException -> 0x0081, all -> 0x007e }
            r1.L$2 = r7     // Catch:{ CancellationException -> 0x0081, all -> 0x007e }
            r1.label = r6     // Catch:{ CancellationException -> 0x0081, all -> 0x007e }
            java.lang.Object r8 = androidx.concurrent.futures.ListenableFutureKt.await(r14, r1)     // Catch:{ CancellationException -> 0x0081, all -> 0x007e }
            if (r8 != r0) goto L_0x0072
            return r0
        L_0x0072:
            r9 = r2
            r2 = r7
            r7 = r14
        L_0x0075:
            androidx.work.ListenableWorker$Result r8 = (androidx.work.ListenableWorker.Result) r8     // Catch:{ CancellationException -> 0x007b, all -> 0x0028 }
            kotlinx.coroutines.oXIO0o0XI.oIX0oI.II0xO0(r2, r5, r6, r5)
            return r8
        L_0x007b:
            r0 = move-exception
            r8 = r9
            goto L_0x00ae
        L_0x007e:
            r0 = move-exception
            r2 = r7
            goto L_0x0086
        L_0x0081:
            r0 = move-exception
            r8 = r2
            r2 = r7
            r7 = r14
            goto L_0x00ae
        L_0x0086:
            java.lang.String r4 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG     // Catch:{ all -> 0x00ac }
            androidx.work.ListenableWorker r7 = r1.$delegate     // Catch:{ all -> 0x00ac }
            androidx.work.Logger r8 = androidx.work.Logger.get()     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r9.<init>()     // Catch:{ all -> 0x00ac }
            r9.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.Class r3 = r7.getClass()     // Catch:{ all -> 0x00ac }
            r9.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = " threw exception in startWork."
            r9.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r9.toString()     // Catch:{ all -> 0x00ac }
            r8.debug(r4, r3, r0)     // Catch:{ all -> 0x00ac }
            throw r0     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r0 = move-exception
            goto L_0x00ef
        L_0x00ae:
            java.lang.String r9 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG     // Catch:{ all -> 0x00ac }
            androidx.work.ListenableWorker r10 = r1.$delegate     // Catch:{ all -> 0x00ac }
            androidx.work.Logger r11 = androidx.work.Logger.get()     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r12.<init>()     // Catch:{ all -> 0x00ac }
            r12.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.Class r3 = r10.getClass()     // Catch:{ all -> 0x00ac }
            r12.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = " was cancelled"
            r12.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r12.toString()     // Catch:{ all -> 0x00ac }
            r11.debug(r9, r3, r0)     // Catch:{ all -> 0x00ac }
            int r3 = r8.get()     // Catch:{ all -> 0x00ac }
            if (r3 == r4) goto L_0x00db
            r3 = 1
            goto L_0x00dc
        L_0x00db:
            r3 = 0
        L_0x00dc:
            boolean r4 = r7.isCancelled()     // Catch:{ all -> 0x00ac }
            if (r4 == 0) goto L_0x00ee
            if (r3 == 0) goto L_0x00ee
            androidx.work.impl.workers.ConstraintTrackingWorker$ConstraintUnsatisfiedException r0 = new androidx.work.impl.workers.ConstraintTrackingWorker$ConstraintUnsatisfiedException     // Catch:{ all -> 0x00ac }
            int r3 = r8.get()     // Catch:{ all -> 0x00ac }
            r0.<init>(r3)     // Catch:{ all -> 0x00ac }
            throw r0     // Catch:{ all -> 0x00ac }
        L_0x00ee:
            throw r0     // Catch:{ all -> 0x00ac }
        L_0x00ef:
            kotlinx.coroutines.oXIO0o0XI.oIX0oI.II0xO0(r2, r5, r6, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(xII xii, I0Io<? super ListenableWorker.Result> i0Io) {
        return ((ConstraintTrackingWorker$runWorker$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
