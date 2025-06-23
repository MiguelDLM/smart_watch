package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Set<String> mCancelledIds = new HashSet();
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    @Nullable
    private PowerManager.WakeLock mForegroundLock = null;
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private final Object mLock = new Object();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();
    private WorkDatabase mWorkDatabase;
    private Map<String, Set<StartStopToken>> mWorkRuns = new HashMap();
    private TaskExecutor mWorkTaskExecutor;

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    @Nullable
    private WorkerWrapper cleanUpWorkerUnsafe(@NonNull String str) {
        boolean z;
        WorkerWrapper remove = this.mForegroundWorkMap.remove(str);
        if (remove != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            remove = this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z) {
            stopForegroundService();
        }
        return remove;
    }

    @Nullable
    private WorkerWrapper getWorkerWrapperUnsafe(@NonNull String str) {
        WorkerWrapper workerWrapper = this.mForegroundWorkMap.get(str);
        if (workerWrapper == null) {
            return this.mEnqueuedWorkMap.get(str);
        }
        return workerWrapper;
    }

    private static boolean interrupt(@NonNull String str, @Nullable WorkerWrapper workerWrapper, int i) {
        if (workerWrapper != null) {
            workerWrapper.interrupt(i);
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "WorkerWrapper interrupted for " + str);
            return true;
        }
        Logger logger2 = Logger.get();
        String str3 = TAG;
        logger2.debug(str3, "WorkerWrapper could not be found for " + str);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnExecuted$2(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.mLock) {
            try {
                for (ExecutionListener onExecuted : this.mOuterListeners) {
                    onExecuted.onExecuted(workGenerationalId, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ WorkSpec lambda$startWork$0(ArrayList arrayList, String str) throws Exception {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(str));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startWork$1(ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        boolean z;
        try {
            z = ((Boolean) listenableFuture.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z = true;
        }
        onExecuted(workerWrapper, z);
    }

    private void onExecuted(@NonNull WorkerWrapper workerWrapper, boolean z) {
        synchronized (this.mLock) {
            try {
                WorkGenerationalId workGenerationalId = workerWrapper.getWorkGenerationalId();
                String workSpecId = workGenerationalId.getWorkSpecId();
                if (getWorkerWrapperUnsafe(workSpecId) == workerWrapper) {
                    cleanUpWorkerUnsafe(workSpecId);
                }
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, getClass().getSimpleName() + " " + workSpecId + " executed; reschedule = " + z);
                for (ExecutionListener onExecuted : this.mOuterListeners) {
                    onExecuted.onExecuted(workGenerationalId, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runOnExecuted(@NonNull WorkGenerationalId workGenerationalId, boolean z) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new oIX0oI(this, workGenerationalId, z));
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    @Nullable
    public WorkSpec getRunningWorkSpec(@NonNull String str) {
        synchronized (this.mLock) {
            try {
                WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
                if (workerWrapperUnsafe == null) {
                    return null;
                }
                WorkSpec workSpec = workerWrapperUnsafe.getWorkSpec();
                return workSpec;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasWork() {
        boolean z;
        synchronized (this.mLock) {
            try {
                if (this.mEnqueuedWorkMap.isEmpty()) {
                    if (this.mForegroundWorkMap.isEmpty()) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean isCancelled(@NonNull String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean z;
        synchronized (this.mLock) {
            if (getWorkerWrapperUnsafe(str) != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.info(str2, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
                if (remove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = newWakeLock;
                        newWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, remove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, remove.getWorkGenerationalId(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean startWork(@NonNull StartStopToken startStopToken) {
        return startWork(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    public boolean stopAndCancelWork(@NonNull String str, int i) {
        WorkerWrapper cleanUpWorkerUnsafe;
        synchronized (this.mLock) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(str);
        }
        return interrupt(str, cleanUpWorkerUnsafe, i);
    }

    public boolean stopForegroundWork(@NonNull StartStopToken startStopToken, int i) {
        WorkerWrapper cleanUpWorkerUnsafe;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
        }
        return interrupt(workSpecId, cleanUpWorkerUnsafe, i);
    }

    public boolean stopWork(@NonNull StartStopToken startStopToken, int i) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.get(workSpecId) != null) {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.debug(str, "Ignored stopWork. WorkerWrapper " + workSpecId + " is in foreground");
                    return false;
                }
                Set set = this.mWorkRuns.get(workSpecId);
                if (set != null) {
                    if (set.contains(startStopToken)) {
                        WorkerWrapper cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
                        return interrupt(workSpecId, cleanUpWorkerUnsafe, i);
                    }
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean startWork(@androidx.annotation.NonNull androidx.work.impl.StartStopToken r13, @androidx.annotation.Nullable androidx.work.WorkerParameters.RuntimeExtras r14) {
        /*
            r12 = this;
            androidx.work.impl.model.WorkGenerationalId r0 = r13.getId()
            java.lang.String r1 = r0.getWorkSpecId()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            androidx.work.impl.WorkDatabase r2 = r12.mWorkDatabase
            androidx.work.impl.II0xO0 r3 = new androidx.work.impl.II0xO0
            r3.<init>(r12, r9, r1)
            java.lang.Object r2 = r2.runInTransaction(r3)
            r8 = r2
            androidx.work.impl.model.WorkSpec r8 = (androidx.work.impl.model.WorkSpec) r8
            r2 = 0
            if (r8 != 0) goto L_0x003c
            androidx.work.Logger r13 = androidx.work.Logger.get()
            java.lang.String r14 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Didn't find WorkSpec for id "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r13.warning(r14, r1)
            r12.runOnExecuted(r0, r2)
            return r2
        L_0x003c:
            java.lang.Object r10 = r12.mLock
            monitor-enter(r10)
            boolean r3 = r12.isEnqueued(r1)     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x008f
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.StartStopToken>> r14 = r12.mWorkRuns     // Catch:{ all -> 0x0088 }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0088 }
            java.util.Set r14 = (java.util.Set) r14     // Catch:{ all -> 0x0088 }
            java.util.Iterator r1 = r14.iterator()     // Catch:{ all -> 0x0088 }
            java.lang.Object r1 = r1.next()     // Catch:{ all -> 0x0088 }
            androidx.work.impl.StartStopToken r1 = (androidx.work.impl.StartStopToken) r1     // Catch:{ all -> 0x0088 }
            androidx.work.impl.model.WorkGenerationalId r1 = r1.getId()     // Catch:{ all -> 0x0088 }
            int r1 = r1.getGeneration()     // Catch:{ all -> 0x0088 }
            int r3 = r0.getGeneration()     // Catch:{ all -> 0x0088 }
            if (r1 != r3) goto L_0x008a
            r14.add(r13)     // Catch:{ all -> 0x0088 }
            androidx.work.Logger r13 = androidx.work.Logger.get()     // Catch:{ all -> 0x0088 }
            java.lang.String r14 = TAG     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = "Work "
            r1.append(r3)     // Catch:{ all -> 0x0088 }
            r1.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = " is already enqueued for processing"
            r1.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0088 }
            r13.debug(r14, r0)     // Catch:{ all -> 0x0088 }
            goto L_0x008d
        L_0x0088:
            r13 = move-exception
            goto L_0x0101
        L_0x008a:
            r12.runOnExecuted(r0, r2)     // Catch:{ all -> 0x0088 }
        L_0x008d:
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x008f:
            int r3 = r8.getGeneration()     // Catch:{ all -> 0x0088 }
            int r4 = r0.getGeneration()     // Catch:{ all -> 0x0088 }
            if (r3 == r4) goto L_0x009e
            r12.runOnExecuted(r0, r2)     // Catch:{ all -> 0x0088 }
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x009e:
            androidx.work.impl.WorkerWrapper$Builder r11 = new androidx.work.impl.WorkerWrapper$Builder     // Catch:{ all -> 0x0088 }
            android.content.Context r3 = r12.mAppContext     // Catch:{ all -> 0x0088 }
            androidx.work.Configuration r4 = r12.mConfiguration     // Catch:{ all -> 0x0088 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r5 = r12.mWorkTaskExecutor     // Catch:{ all -> 0x0088 }
            androidx.work.impl.WorkDatabase r7 = r12.mWorkDatabase     // Catch:{ all -> 0x0088 }
            r2 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.WorkerWrapper$Builder r14 = r11.withRuntimeExtras(r14)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.WorkerWrapper r14 = r14.build()     // Catch:{ all -> 0x0088 }
            com.google.common.util.concurrent.ListenableFuture r2 = r14.launch()     // Catch:{ all -> 0x0088 }
            androidx.work.impl.I0Io r3 = new androidx.work.impl.I0Io     // Catch:{ all -> 0x0088 }
            r3.<init>(r12, r2, r14)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r12.mWorkTaskExecutor     // Catch:{ all -> 0x0088 }
            java.util.concurrent.Executor r4 = r4.getMainThreadExecutor()     // Catch:{ all -> 0x0088 }
            r2.addListener(r3, r4)     // Catch:{ all -> 0x0088 }
            java.util.Map<java.lang.String, androidx.work.impl.WorkerWrapper> r2 = r12.mEnqueuedWorkMap     // Catch:{ all -> 0x0088 }
            r2.put(r1, r14)     // Catch:{ all -> 0x0088 }
            java.util.HashSet r14 = new java.util.HashSet     // Catch:{ all -> 0x0088 }
            r14.<init>()     // Catch:{ all -> 0x0088 }
            r14.add(r13)     // Catch:{ all -> 0x0088 }
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.StartStopToken>> r13 = r12.mWorkRuns     // Catch:{ all -> 0x0088 }
            r13.put(r1, r14)     // Catch:{ all -> 0x0088 }
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            androidx.work.Logger r13 = androidx.work.Logger.get()
            java.lang.String r14 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class r2 = r12.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = ": processing "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r13.debug(r14, r0)
            r13 = 1
            return r13
        L_0x0101:
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.Processor.startWork(androidx.work.impl.StartStopToken, androidx.work.WorkerParameters$RuntimeExtras):boolean");
    }
}
