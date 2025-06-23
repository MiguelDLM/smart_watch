package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.WorkQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class WorkQueue {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;

    @OXOo.OOXIXo
    private final Executor executor;
    private final int maxConcurrent;

    @OXOo.oOoXoXO
    private WorkNode pendingJobs;
    private int runningCount;

    @OXOo.oOoXoXO
    private WorkNode runningJobs;

    @OXOo.OOXIXo
    private final ReentrantLock workLock;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: assert, reason: not valid java name */
        public final void m220assert(boolean z) {
            if (z) {
            } else {
                throw new FacebookException("Validation failed");
            }
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    /* loaded from: classes8.dex */
    public final class WorkNode implements WorkItem {

        @OXOo.OOXIXo
        private final Runnable callback;
        private boolean isRunning;

        @OXOo.oOoXoXO
        private WorkNode next;

        @OXOo.oOoXoXO
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(@OXOo.OOXIXo WorkQueue this$0, Runnable callback) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(callback, "callback");
            this.this$0 = this$0;
            this.callback = callback;
        }

        @OXOo.OOXIXo
        public final WorkNode addToList(@OXOo.oOoXoXO WorkNode workNode, boolean z) {
            boolean z2;
            WorkNode workNode2;
            Companion companion = WorkQueue.Companion;
            boolean z3 = false;
            if (this.next == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            companion.m220assert(z2);
            if (this.prev == null) {
                z3 = true;
            }
            companion.m220assert(z3);
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                WorkNode workNode3 = workNode.prev;
                this.prev = workNode3;
                if (workNode3 != null) {
                    workNode3.next = this;
                }
                WorkNode workNode4 = this.next;
                if (workNode4 != null) {
                    if (workNode3 == null) {
                        workNode2 = null;
                    } else {
                        workNode2 = workNode3.next;
                    }
                    workNode4.prev = workNode2;
                }
            }
            if (z) {
                return this;
            }
            return workNode;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    reentrantLock.unlock();
                    return true;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                reentrantLock.unlock();
                return false;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @OXOo.OOXIXo
        public final Runnable getCallback() {
            return this.callback;
        }

        @OXOo.oOoXoXO
        public final WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @OXOo.oOoXoXO
        public final WorkNode removeFromList(@OXOo.oOoXoXO WorkNode workNode) {
            boolean z;
            Companion companion = WorkQueue.Companion;
            boolean z2 = false;
            if (this.next != null) {
                z = true;
            } else {
                z = false;
            }
            companion.m220assert(z);
            if (this.prev != null) {
                z2 = true;
            }
            companion.m220assert(z2);
            if (workNode == this && (workNode = this.next) == this) {
                workNode = null;
            }
            WorkNode workNode2 = this.next;
            if (workNode2 != null) {
                workNode2.prev = this.prev;
            }
            WorkNode workNode3 = this.prev;
            if (workNode3 != null) {
                workNode3.next = workNode2;
            }
            this.prev = null;
            this.next = null;
            return workNode;
        }

        public void setRunning(boolean z) {
            this.isRunning = z;
        }

        public final void verify(boolean z) {
            WorkNode workNode;
            boolean z2;
            WorkNode workNode2;
            boolean z3;
            Companion companion = WorkQueue.Companion;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            boolean z4 = false;
            if (workNode == this) {
                z2 = true;
            } else {
                z2 = false;
            }
            companion.m220assert(z2);
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            if (workNode2 == this) {
                z3 = true;
            } else {
                z3 = false;
            }
            companion.m220assert(z3);
            if (isRunning() == z) {
                z4 = true;
            }
            companion.m220assert(z4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public WorkQueue() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return workQueue.addActiveWorkItem(runnable, z);
    }

    private final void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.XI0IXoo
            @Override // java.lang.Runnable
            public final void run() {
                WorkQueue.m219execute$lambda2(WorkQueue.WorkNode.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execute$lambda-2, reason: not valid java name */
    public static final void m219execute$lambda2(WorkNode node, WorkQueue this$0) {
        IIX0o.x0xO0oo(node, "$node");
        IIX0o.x0xO0oo(this$0, "this$0");
        try {
            node.getCallback().run();
        } finally {
            this$0.finishItemAndStartNew(node);
        }
    }

    private final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setRunning(true);
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void startItem() {
        finishItemAndStartNew(null);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final WorkItem addActiveWorkItem(@OXOo.OOXIXo Runnable callback) {
        IIX0o.x0xO0oo(callback, "callback");
        return addActiveWorkItem$default(this, callback, false, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        throw new java.lang.IllegalStateException("Required value was null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r1 = com.facebook.internal.WorkQueue.Companion;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if (r6.runningCount != r4) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r1.m220assert(r2);
        r1 = kotlin.oXIO0o0XI.f29392oIX0oI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r0.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r1 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        r1.verify(true);
        r4 = r4 + 1;
        r1 = r1.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r1 != r6.runningJobs) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void validate() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r6.workLock
            r0.lock()
            com.facebook.internal.WorkQueue$WorkNode r1 = r6.runningJobs     // Catch: java.lang.Throwable -> L1b
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
        Lc:
            if (r1 == 0) goto L1d
            r1.verify(r3)     // Catch: java.lang.Throwable -> L1b
            int r4 = r4 + r3
            com.facebook.internal.WorkQueue$WorkNode r1 = r1.getNext()     // Catch: java.lang.Throwable -> L1b
            com.facebook.internal.WorkQueue$WorkNode r5 = r6.runningJobs     // Catch: java.lang.Throwable -> L1b
            if (r1 != r5) goto Lc
            goto L25
        L1b:
            r1 = move-exception
            goto L35
        L1d:
            java.lang.String r1 = "Required value was null."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b
            throw r2     // Catch: java.lang.Throwable -> L1b
        L25:
            com.facebook.internal.WorkQueue$Companion r1 = com.facebook.internal.WorkQueue.Companion     // Catch: java.lang.Throwable -> L1b
            int r5 = r6.runningCount     // Catch: java.lang.Throwable -> L1b
            if (r5 != r4) goto L2c
            r2 = 1
        L2c:
            com.facebook.internal.WorkQueue.Companion.access$assert(r1, r2)     // Catch: java.lang.Throwable -> L1b
            kotlin.oXIO0o0XI r1 = kotlin.oXIO0o0XI.f29392oIX0oI     // Catch: java.lang.Throwable -> L1b
            r0.unlock()
            return
        L35:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WorkQueue.validate():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public WorkQueue(int i) {
        this(i, null, 2, 0 == true ? 1 : 0);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final WorkItem addActiveWorkItem(@OXOo.OOXIXo Runnable callback, boolean z) {
        IIX0o.x0xO0oo(callback, "callback");
        WorkNode workNode = new WorkNode(this, callback);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @XO0OX.xoIox
    public WorkQueue(int i, @OXOo.OOXIXo Executor executor) {
        IIX0o.x0xO0oo(executor, "executor");
        this.maxConcurrent = i;
        this.executor = executor;
        this.workLock = new ReentrantLock();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ WorkQueue(int r1, java.util.concurrent.Executor r2, int r3, kotlin.jvm.internal.IIXOooo r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L6
            r1 = 8
        L6:
            r3 = r3 & 2
            if (r3 == 0) goto L10
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r2 = com.facebook.FacebookSdk.getExecutor()
        L10:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WorkQueue.<init>(int, java.util.concurrent.Executor, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
