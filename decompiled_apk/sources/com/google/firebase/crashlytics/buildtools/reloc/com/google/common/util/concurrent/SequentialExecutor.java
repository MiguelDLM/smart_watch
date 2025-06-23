package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: classes10.dex */
public final class SequentialExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;

    @GuardedBy("queue")
    private final Deque<Runnable> queue = new ArrayDeque();

    @GuardedBy("queue")
    private WorkerRunningState workerRunningState = WorkerRunningState.IDLE;

    @GuardedBy("queue")
    private long workerRunCount = 0;
    private final QueueWorker worker = new QueueWorker();

    /* loaded from: classes10.dex */
    public final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
        
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.log.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void workOnQueue() {
            /*
                r8 = this;
                r0 = 0
                r1 = 0
            L2:
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor r2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L57
                java.util.Deque r2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$100(r2)     // Catch: java.lang.Throwable -> L57
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L57
                if (r0 != 0) goto L2d
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor r0 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$200(r0)     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L20
                if (r0 != r3) goto L22
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                r0 = move-exception
                goto L75
            L22:
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor r0 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$308(r0)     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor r0 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$202(r0, r3)     // Catch: java.lang.Throwable -> L20
                r0 = 1
            L2d:
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                java.util.Deque r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$100(r3)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L20
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L20
                if (r3 != 0) goto L4d
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor r0 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L20
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$202(r0, r3)     // Catch: java.lang.Throwable -> L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L4c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4c:
                return
            L4d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L57
                r1 = r1 | r2
                r3.run()     // Catch: java.lang.Throwable -> L57 java.lang.RuntimeException -> L59
                goto L2
            L57:
                r0 = move-exception
                goto L77
            L59:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.access$400()     // Catch: java.lang.Throwable -> L57
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L57
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57
                r6.<init>()     // Catch: java.lang.Throwable -> L57
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L57
                r6.append(r3)     // Catch: java.lang.Throwable -> L57
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L57
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L57
                goto L2
            L75:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                throw r0     // Catch: java.lang.Throwable -> L57
            L77:
                if (r1 == 0) goto L80
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L80:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public SequentialExecutor(Executor executor) {
        this.executor = (Executor) Preconditions.checkNotNull(executor);
    }

    public static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = 1 + j;
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0066 A[ADDED_TO_REGION] */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(final java.lang.Runnable r8) {
        /*
            r7 = this;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions.checkNotNull(r8)
            java.util.Deque<java.lang.Runnable> r0 = r7.queue
            monitor-enter(r0)
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = r7.workerRunningState     // Catch: java.lang.Throwable -> L6d
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L6d
            if (r1 == r2) goto L6f
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUED     // Catch: java.lang.Throwable -> L6d
            if (r1 != r2) goto L11
            goto L6f
        L11:
            long r3 = r7.workerRunCount     // Catch: java.lang.Throwable -> L6d
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$1 r1 = new com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$1     // Catch: java.lang.Throwable -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6d
            java.util.Deque<java.lang.Runnable> r8 = r7.queue     // Catch: java.lang.Throwable -> L6d
            r8.add(r1)     // Catch: java.lang.Throwable -> L6d
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r8 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L6d
            r7.workerRunningState = r8     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.Executor r0 = r7.executor     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$QueueWorker r5 = r7.worker     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            r0.execute(r5)     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = r7.workerRunningState
            if (r0 == r8) goto L2e
            return
        L2e:
            java.util.Deque<java.lang.Runnable> r0 = r7.queue
            monitor-enter(r0)
            long r5 = r7.workerRunCount     // Catch: java.lang.Throwable -> L3e
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L40
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = r7.workerRunningState     // Catch: java.lang.Throwable -> L3e
            if (r1 != r8) goto L40
            r7.workerRunningState = r2     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r8 = move-exception
            goto L42
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r8
        L44:
            r8 = move-exception
            goto L47
        L46:
            r8 = move-exception
        L47:
            java.util.Deque<java.lang.Runnable> r2 = r7.queue
            monitor-enter(r2)
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = r7.workerRunningState     // Catch: java.lang.Throwable -> L55
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L55
            if (r0 == r3) goto L57
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L55
            if (r0 != r3) goto L61
            goto L57
        L55:
            r8 = move-exception
            goto L6b
        L57:
            java.util.Deque<java.lang.Runnable> r0 = r7.queue     // Catch: java.lang.Throwable -> L55
            boolean r0 = r0.removeLastOccurrence(r1)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L61
            r0 = 1
            goto L62
        L61:
            r0 = 0
        L62:
            boolean r1 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L6a
            if (r0 != 0) goto L6a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            return
        L6a:
            throw r8     // Catch: java.lang.Throwable -> L55
        L6b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            throw r8
        L6d:
            r8 = move-exception
            goto L76
        L6f:
            java.util.Deque<java.lang.Runnable> r1 = r7.queue     // Catch: java.lang.Throwable -> L6d
            r1.add(r8)     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            return
        L76:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.SequentialExecutor.execute(java.lang.Runnable):void");
    }
}
