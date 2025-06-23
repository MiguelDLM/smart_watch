package androidx.work.impl.utils;

import XXO0.oIX0oI;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");

    private EnqueueRunnable() {
    }

    @VisibleForTesting
    public static boolean addToDatabase(@NonNull WorkContinuationImpl workContinuationImpl) {
        WorkManagerImpl workManagerImpl = workContinuationImpl.getWorkManagerImpl();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.getConfiguration(), workContinuationImpl);
            boolean processContinuation = processContinuation(workContinuationImpl);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public static void enqueue(@NonNull WorkContinuationImpl workContinuationImpl) {
        if (workContinuationImpl.hasCycles()) {
            throw new IllegalStateException("WorkContinuation has cycles (" + workContinuationImpl + oIX0oI.I0Io.f17331I0Io);
        } else if (addToDatabase(workContinuationImpl)) {
            scheduleWorkInBackground(workContinuationImpl);
        }
    }

    private static boolean enqueueContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r18, @androidx.annotation.NonNull java.util.List<? extends androidx.work.WorkRequest> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            androidx.work.Configuration r3 = r18.getConfiguration()
            androidx.work.Clock r3 = r3.getClock()
            long r3 = r3.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r18.getWorkDatabase()
            r7 = 0
            if (r0 == 0) goto L_0x001e
            int r8 = r0.length
            if (r8 <= 0) goto L_0x001e
            r8 = 1
            goto L_0x001f
        L_0x001e:
            r8 = 0
        L_0x001f:
            if (r8 == 0) goto L_0x006c
            int r9 = r0.length
            r10 = 0
            r11 = 1
            r12 = 0
            r13 = 0
        L_0x0026:
            if (r10 >= r9) goto L_0x006f
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.workSpecDao()
            androidx.work.impl.model.WorkSpec r15 = r15.getWorkSpec(r14)
            if (r15 != 0) goto L_0x0054
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Prerequisite "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = " doesn't exist; not enqueuing"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.error(r1, r2)
            return r7
        L_0x0054:
            androidx.work.WorkInfo$State r14 = r15.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x005c
            r15 = 1
            goto L_0x005d
        L_0x005c:
            r15 = 0
        L_0x005d:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x0064
            r13 = 1
            goto L_0x0069
        L_0x0064:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x0069
            r12 = 1
        L_0x0069:
            int r10 = r10 + 1
            goto L_0x0026
        L_0x006c:
            r11 = 1
            r12 = 0
            r13 = 0
        L_0x006f:
            boolean r9 = android.text.TextUtils.isEmpty(r21)
            if (r9 != 0) goto L_0x0152
            if (r8 != 0) goto L_0x0152
            androidx.work.impl.model.WorkSpecDao r10 = r5.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x0152
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x008d
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x0090
        L_0x008d:
            r14 = r18
            goto L_0x00d1
        L_0x0090:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x00af
            java.util.Iterator r2 = r10.iterator()
        L_0x0098:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00af
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r14 = r14.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 == r15) goto L_0x00ae
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r14 != r15) goto L_0x0098
        L_0x00ae:
            return r7
        L_0x00af:
            r14 = r18
            androidx.work.impl.utils.CancelWorkRunnable.forNameInline(r1, r14)
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00bc:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00ce
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r15 = r15.id
            r2.delete(r15)
            goto L_0x00bc
        L_0x00ce:
            r6 = 1
            goto L_0x0155
        L_0x00d1:
            androidx.work.impl.model.DependencyDao r8 = r5.dependencyDao()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00de:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x0118
            java.lang.Object r16 = r10.next()
            r6 = r16
            androidx.work.impl.model.WorkSpec$IdAndState r6 = (androidx.work.impl.model.WorkSpec.IdAndState) r6
            java.lang.String r7 = r6.id
            boolean r7 = r8.hasDependents(r7)
            if (r7 != 0) goto L_0x0112
            androidx.work.WorkInfo$State r7 = r6.state
            r17 = r8
            androidx.work.WorkInfo$State r8 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r8) goto L_0x00fe
            r8 = 1
            goto L_0x00ff
        L_0x00fe:
            r8 = 0
        L_0x00ff:
            r8 = r8 & r11
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x0106
            r13 = 1
            goto L_0x010b
        L_0x0106:
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x010b
            r12 = 1
        L_0x010b:
            java.lang.String r6 = r6.id
            r15.add(r6)
            r11 = r8
            goto L_0x0114
        L_0x0112:
            r17 = r8
        L_0x0114:
            r8 = r17
            r7 = 0
            goto L_0x00de
        L_0x0118:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x0144
            if (r12 != 0) goto L_0x0120
            if (r13 == 0) goto L_0x0144
        L_0x0120:
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.List r6 = r2.getWorkSpecIdAndStatesForName(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x012c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x013e
            java.lang.Object r7 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r7 = r7.id
            r2.delete(r7)
            goto L_0x012c
        L_0x013e:
            java.util.List r15 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x0144:
            java.lang.Object[] r0 = r15.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x014f
            r8 = 1
            goto L_0x0150
        L_0x014f:
            r8 = 0
        L_0x0150:
            r6 = 0
            goto L_0x0155
        L_0x0152:
            r14 = r18
            goto L_0x0150
        L_0x0155:
            java.util.Iterator r2 = r19.iterator()
        L_0x0159:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01e6
            java.lang.Object r7 = r2.next()
            androidx.work.WorkRequest r7 = (androidx.work.WorkRequest) r7
            androidx.work.impl.model.WorkSpec r10 = r7.getWorkSpec()
            if (r8 == 0) goto L_0x0180
            if (r11 != 0) goto L_0x0180
            if (r13 == 0) goto L_0x0174
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r10.state = r15
            goto L_0x0182
        L_0x0174:
            if (r12 == 0) goto L_0x017b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r10.state = r15
            goto L_0x0182
        L_0x017b:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r10.state = r15
            goto L_0x0182
        L_0x0180:
            r10.lastEnqueueTime = r3
        L_0x0182:
            androidx.work.WorkInfo$State r15 = r10.state
            r19 = r2
            androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 != r2) goto L_0x018b
            r6 = 1
        L_0x018b:
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.List r15 = r18.getSchedulers()
            androidx.work.impl.model.WorkSpec r10 = androidx.work.impl.utils.EnqueueUtilsKt.wrapWorkSpecIfNeeded(r15, r10)
            r2.insertWorkSpec(r10)
            if (r8 == 0) goto L_0x01bd
            int r2 = r0.length
            r10 = 0
        L_0x019e:
            if (r10 >= r2) goto L_0x01bd
            r15 = r0[r10]
            r17 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r20 = r2
            java.lang.String r2 = r7.getStringId()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r5.dependencyDao()
            r2.insertDependency(r0)
            int r10 = r10 + 1
            r2 = r20
            r0 = r17
            goto L_0x019e
        L_0x01bd:
            r17 = r0
            androidx.work.impl.model.WorkTagDao r0 = r5.workTagDao()
            java.lang.String r2 = r7.getStringId()
            java.util.Set r10 = r7.getTags()
            r0.insertTags(r2, r10)
            if (r9 != 0) goto L_0x01e0
            androidx.work.impl.model.WorkNameDao r0 = r5.workNameDao()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r7 = r7.getStringId()
            r2.<init>(r1, r7)
            r0.insert(r2)
        L_0x01e0:
            r2 = r19
            r0 = r17
            goto L_0x0159
        L_0x01e6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean processContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z |= processContinuation(next);
                } else {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.warning(str, "Already enqueued work ids (" + TextUtils.join(", ", next.getIds()) + oIX0oI.I0Io.f17331I0Io);
                }
            }
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    @VisibleForTesting
    public static void scheduleWorkInBackground(@NonNull WorkContinuationImpl workContinuationImpl) {
        WorkManagerImpl workManagerImpl = workContinuationImpl.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
