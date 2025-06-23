package com.facebook.bolts;

import com.facebook.bolts.BoltsExecutors;
import com.facebook.bolts.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class Task<TResult> {

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final ExecutorService BACKGROUND_EXECUTOR;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final Executor IMMEDIATE_EXECUTOR;

    @OXOo.OOXIXo
    private static final Task<?> TASK_CANCELLED;

    @OXOo.OOXIXo
    private static final Task<Boolean> TASK_FALSE;

    @OXOo.OOXIXo
    private static final Task<?> TASK_NULL;

    @OXOo.OOXIXo
    private static final Task<Boolean> TASK_TRUE;

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Executor UI_THREAD_EXECUTOR;

    @OXOo.oOoXoXO
    private static volatile UnobservedExceptionHandler unobservedExceptionHandler;
    private boolean cancelledField;
    private boolean completeField;
    private final Condition condition;

    @OXOo.oOoXoXO
    private List<Continuation<TResult, Void>> continuations;

    @OXOo.oOoXoXO
    private Exception errorField;
    private boolean errorHasBeenObserved;

    @OXOo.OOXIXo
    private final ReentrantLock lock;

    @OXOo.oOoXoXO
    private TResult resultField;

    @OXOo.oOoXoXO
    private UnobservedErrorNotifier unobservedErrorNotifier;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: call$lambda-2, reason: not valid java name */
        public static final void m184call$lambda2(CancellationToken cancellationToken, com.facebook.bolts.TaskCompletionSource tcs, Callable callable) {
            IIX0o.x0xO0oo(tcs, "$tcs");
            IIX0o.x0xO0oo(callable, "$callable");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return;
            }
            try {
                tcs.setResult(callable.call());
            } catch (CancellationException unused) {
                tcs.setCancelled();
            } catch (Exception e) {
                tcs.setError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeAfterTask(final com.facebook.bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.Oxx0IOOO
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m185completeAfterTask$lambda7(CancellationToken.this, taskCompletionSource, continuation, task);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: completeAfterTask$lambda-7, reason: not valid java name */
        public static final void m185completeAfterTask$lambda7(final CancellationToken cancellationToken, final com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Task task) {
            IIX0o.x0xO0oo(tcs, "$tcs");
            IIX0o.x0xO0oo(continuation, "$continuation");
            IIX0o.x0xO0oo(task, "$task");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return;
            }
            try {
                Task task2 = (Task) continuation.then(task);
                if (task2 == null) {
                    tcs.setResult(null);
                } else {
                    task2.continueWith(new Continuation() { // from class: com.facebook.bolts.II0XooXoX
                        @Override // com.facebook.bolts.Continuation
                        public final Object then(Task task3) {
                            Void m186completeAfterTask$lambda7$lambda6;
                            m186completeAfterTask$lambda7$lambda6 = Task.Companion.m186completeAfterTask$lambda7$lambda6(CancellationToken.this, tcs, task3);
                            return m186completeAfterTask$lambda7$lambda6;
                        }
                    });
                }
            } catch (CancellationException unused) {
                tcs.setCancelled();
            } catch (Exception e) {
                tcs.setError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: completeAfterTask$lambda-7$lambda-6, reason: not valid java name */
        public static final Void m186completeAfterTask$lambda7$lambda6(CancellationToken cancellationToken, com.facebook.bolts.TaskCompletionSource tcs, Task task) {
            IIX0o.x0xO0oo(tcs, "$tcs");
            IIX0o.x0xO0oo(task, "task");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return null;
            }
            if (task.isCancelled()) {
                tcs.setCancelled();
            } else if (task.isFaulted()) {
                tcs.setError(task.getError());
            } else {
                tcs.setResult(task.getResult());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeImmediately(final com.facebook.bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.ooOOo0oXI
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m187completeImmediately$lambda5(CancellationToken.this, taskCompletionSource, continuation, task);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: completeImmediately$lambda-5, reason: not valid java name */
        public static final void m187completeImmediately$lambda5(CancellationToken cancellationToken, com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Task task) {
            IIX0o.x0xO0oo(tcs, "$tcs");
            IIX0o.x0xO0oo(continuation, "$continuation");
            IIX0o.x0xO0oo(task, "$task");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return;
            }
            try {
                tcs.setResult(continuation.then(task));
            } catch (CancellationException unused) {
                tcs.setCancelled();
            } catch (Exception e) {
                tcs.setError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: delay$lambda-0, reason: not valid java name */
        public static final void m188delay$lambda0(com.facebook.bolts.TaskCompletionSource tcs) {
            IIX0o.x0xO0oo(tcs, "$tcs");
            tcs.trySetResult(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: delay$lambda-1, reason: not valid java name */
        public static final void m189delay$lambda1(ScheduledFuture scheduledFuture, com.facebook.bolts.TaskCompletionSource tcs) {
            IIX0o.x0xO0oo(tcs, "$tcs");
            scheduledFuture.cancel(true);
            tcs.trySetCancelled();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: whenAny$lambda-4, reason: not valid java name */
        public static final Void m190whenAny$lambda4(AtomicBoolean isAnyTaskComplete, com.facebook.bolts.TaskCompletionSource firstCompleted, Task it) {
            IIX0o.x0xO0oo(isAnyTaskComplete, "$isAnyTaskComplete");
            IIX0o.x0xO0oo(firstCompleted, "$firstCompleted");
            IIX0o.x0xO0oo(it, "it");
            if (isAnyTaskComplete.compareAndSet(false, true)) {
                firstCompleted.setResult(it);
                return null;
            }
            it.getError();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: whenAnyResult$lambda-3, reason: not valid java name */
        public static final Void m191whenAnyResult$lambda3(AtomicBoolean isAnyTaskComplete, com.facebook.bolts.TaskCompletionSource firstCompleted, Task it) {
            IIX0o.x0xO0oo(isAnyTaskComplete, "$isAnyTaskComplete");
            IIX0o.x0xO0oo(firstCompleted, "$firstCompleted");
            IIX0o.x0xO0oo(it, "it");
            if (isAnyTaskComplete.compareAndSet(false, true)) {
                firstCompleted.setResult(it);
                return null;
            }
            it.getError();
            return null;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.OOXIXo Executor executor) {
            IIX0o.x0xO0oo(callable, "callable");
            IIX0o.x0xO0oo(executor, "executor");
            return call(callable, executor, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> callInBackground(@OXOo.OOXIXo Callable<TResult> callable) {
            IIX0o.x0xO0oo(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> cancelled() {
            return Task.TASK_CANCELLED;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Task<Void> delay(long j) {
            return delay$facebook_bolts_release(j, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Task<Void> delay$facebook_bolts_release(long j, @OXOo.OOXIXo ScheduledExecutorService executor, @OXOo.oOoXoXO CancellationToken cancellationToken) {
            IIX0o.x0xO0oo(executor, "executor");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return cancelled();
            }
            if (j <= 0) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final ScheduledFuture<?> schedule = executor.schedule(new Runnable() { // from class: com.facebook.bolts.xoIox
                @Override // java.lang.Runnable
                public final void run() {
                    Task.Companion.m188delay$lambda0(TaskCompletionSource.this);
                }
            }, j, TimeUnit.MILLISECONDS);
            if (cancellationToken != null) {
                cancellationToken.register(new Runnable() { // from class: com.facebook.bolts.OOXIXo
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m189delay$lambda1(schedule, taskCompletionSource);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> forError(@OXOo.oOoXoXO Exception exc) {
            com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            taskCompletionSource.setError(exc);
            return taskCompletionSource.getTask();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> forResult(@OXOo.oOoXoXO TResult tresult) {
            if (tresult == 0) {
                return Task.TASK_NULL;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
            }
            com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            taskCompletionSource.setResult(tresult);
            return taskCompletionSource.getTask();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final UnobservedExceptionHandler getUnobservedExceptionHandler() {
            return Task.unobservedExceptionHandler;
        }

        @XO0OX.x0XOIxOo
        public final void setUnobservedExceptionHandler(@OXOo.oOoXoXO UnobservedExceptionHandler unobservedExceptionHandler) {
            Task.unobservedExceptionHandler = unobservedExceptionHandler;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Task<Void> whenAll(@OXOo.OOXIXo Collection<? extends Task<?>> tasks) {
            IIX0o.x0xO0oo(tasks, "tasks");
            if (tasks.isEmpty()) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final ArrayList arrayList = new ArrayList();
            final ReentrantLock reentrantLock = new ReentrantLock();
            final AtomicInteger atomicInteger = new AtomicInteger(tasks.size());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Iterator<? extends Task<?>> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().continueWith(new Continuation() { // from class: com.facebook.bolts.Task$Companion$whenAll$1
                    @Override // com.facebook.bolts.Continuation
                    public /* bridge */ /* synthetic */ Object then(Task task) {
                        return then((Task<Object>) task);
                    }

                    @Override // com.facebook.bolts.Continuation
                    @OXOo.oOoXoXO
                    public final Void then(@OXOo.OOXIXo Task<Object> it2) {
                        IIX0o.x0xO0oo(it2, "it");
                        if (it2.isFaulted()) {
                            ReentrantLock reentrantLock2 = reentrantLock;
                            ArrayList<Exception> arrayList2 = arrayList;
                            reentrantLock2.lock();
                            try {
                                arrayList2.add(it2.getError());
                            } finally {
                                reentrantLock2.unlock();
                            }
                        }
                        if (it2.isCancelled()) {
                            atomicBoolean.set(true);
                        }
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (arrayList.size() != 0) {
                                if (arrayList.size() == 1) {
                                    taskCompletionSource.setError(arrayList.get(0));
                                } else {
                                    oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                                    String format = String.format("There were %d exceptions.", Arrays.copyOf(new Object[]{Integer.valueOf(arrayList.size())}, 1));
                                    IIX0o.oO(format, "java.lang.String.format(format, *args)");
                                    taskCompletionSource.setError(new AggregateException(format, arrayList));
                                }
                            } else if (atomicBoolean.get()) {
                                taskCompletionSource.setCancelled();
                            } else {
                                taskCompletionSource.setResult(null);
                            }
                        }
                        return null;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<List<TResult>> whenAllResult(@OXOo.OOXIXo final Collection<Task<TResult>> tasks) {
            IIX0o.x0xO0oo(tasks, "tasks");
            return (Task<List<TResult>>) whenAll(tasks).onSuccess(new Continuation<Void, List<? extends TResult>>() { // from class: com.facebook.bolts.Task$Companion$whenAllResult$1
                @Override // com.facebook.bolts.Continuation
                @OXOo.OOXIXo
                public List<TResult> then(@OXOo.OOXIXo Task<Void> task) {
                    IIX0o.x0xO0oo(task, "task");
                    if (tasks.isEmpty()) {
                        return CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task<TResult>> it = tasks.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getResult());
                    }
                    return arrayList;
                }
            });
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Task<Task<?>> whenAny(@OXOo.OOXIXo Collection<? extends Task<?>> tasks) {
            IIX0o.x0xO0oo(tasks, "tasks");
            if (tasks.isEmpty()) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Iterator<? extends Task<?>> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().continueWith(new Continuation() { // from class: com.facebook.bolts.x0XOIxOo
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        Void m190whenAny$lambda4;
                        m190whenAny$lambda4 = Task.Companion.m190whenAny$lambda4(atomicBoolean, taskCompletionSource, task);
                        return m190whenAny$lambda4;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<Task<TResult>> whenAnyResult(@OXOo.OOXIXo Collection<Task<TResult>> tasks) {
            IIX0o.x0xO0oo(tasks, "tasks");
            if (tasks.isEmpty()) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Iterator<Task<TResult>> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().continueWith(new Continuation() { // from class: com.facebook.bolts.xxIXOIIO
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        Void m191whenAnyResult$lambda3;
                        m191whenAnyResult$lambda3 = Task.Companion.m191whenAnyResult$lambda3(atomicBoolean, taskCompletionSource, task);
                        return m191whenAnyResult$lambda3;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> call(@OXOo.OOXIXo final Callable<TResult> callable, @OXOo.OOXIXo Executor executor, @OXOo.oOoXoXO final CancellationToken cancellationToken) {
            IIX0o.x0xO0oo(callable, "callable");
            IIX0o.x0xO0oo(executor, "executor");
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.oOoXoXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m184call$lambda2(CancellationToken.this, taskCompletionSource, callable);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
            return taskCompletionSource.getTask();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> callInBackground(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.oOoXoXO CancellationToken cancellationToken) {
            IIX0o.x0xO0oo(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, cancellationToken);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Task<Void> delay(long j, @OXOo.oOoXoXO CancellationToken cancellationToken) {
            return delay$facebook_bolts_release(j, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), cancellationToken);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable) {
            IIX0o.x0xO0oo(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.oOoXoXO CancellationToken cancellationToken) {
            IIX0o.x0xO0oo(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, cancellationToken);
        }
    }

    @kotlin.OOXIXo(message = "Please use [TaskCompletionSource] instead. ")
    /* loaded from: classes8.dex */
    public final class TaskCompletionSource extends com.facebook.bolts.TaskCompletionSource<TResult> {
        final /* synthetic */ Task<TResult> this$0;

        public TaskCompletionSource(Task this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }
    }

    /* loaded from: classes8.dex */
    public interface UnobservedExceptionHandler {
        void unobservedException(@OXOo.OOXIXo Task<?> task, @OXOo.OOXIXo UnobservedTaskException unobservedTaskException);
    }

    static {
        BoltsExecutors.Companion companion = BoltsExecutors.Companion;
        BACKGROUND_EXECUTOR = companion.background();
        IMMEDIATE_EXECUTOR = companion.immediate$facebook_bolts_release();
        UI_THREAD_EXECUTOR = AndroidExecutors.Companion.uiThread();
        TASK_NULL = new Task<>((Object) null);
        TASK_TRUE = new Task<>(Boolean.TRUE);
        TASK_FALSE = new Task<>(Boolean.FALSE);
        TASK_CANCELLED = new Task<>(true);
    }

    public Task() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable) {
        return Companion.call(callable);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> callInBackground(@OXOo.OOXIXo Callable<TResult> callable) {
        return Companion.callInBackground(callable);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> cancelled() {
        return Companion.cancelled();
    }

    public static /* synthetic */ Task continueWhile$default(Task task, Callable callable, Continuation continuation, Executor executor, CancellationToken cancellationToken, int i, Object obj) {
        if ((i & 4) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        if ((i & 8) != 0) {
            cancellationToken = null;
        }
        return task.continueWhile(callable, continuation, executor, cancellationToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: continueWith$lambda-10$lambda-9, reason: not valid java name */
    public static final Void m179continueWith$lambda10$lambda9(com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        IIX0o.x0xO0oo(tcs, "$tcs");
        IIX0o.x0xO0oo(continuation, "$continuation");
        IIX0o.x0xO0oo(executor, "$executor");
        IIX0o.x0xO0oo(task, "task");
        Companion.completeImmediately(tcs, continuation, task, executor, cancellationToken);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: continueWithTask$lambda-12$lambda-11, reason: not valid java name */
    public static final Void m180continueWithTask$lambda12$lambda11(com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        IIX0o.x0xO0oo(tcs, "$tcs");
        IIX0o.x0xO0oo(continuation, "$continuation");
        IIX0o.x0xO0oo(executor, "$executor");
        IIX0o.x0xO0oo(task, "task");
        Companion.completeAfterTask(tcs, continuation, task, executor, cancellationToken);
        return null;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Task<Void> delay(long j) {
        return Companion.delay(j);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> forError(@OXOo.oOoXoXO Exception exc) {
        return Companion.forError(exc);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> forResult(@OXOo.oOoXoXO TResult tresult) {
        return Companion.forResult(tresult);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return Companion.getUnobservedExceptionHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: makeVoid$lambda-8, reason: not valid java name */
    public static final Task m181makeVoid$lambda8(Task task) {
        IIX0o.x0xO0oo(task, "task");
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        return Companion.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-13, reason: not valid java name */
    public static final Task m182onSuccess$lambda13(CancellationToken cancellationToken, Continuation continuation, Task task) {
        IIX0o.x0xO0oo(continuation, "$continuation");
        IIX0o.x0xO0oo(task, "task");
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.continueWith(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccessTask$lambda-14, reason: not valid java name */
    public static final Task m183onSuccessTask$lambda14(CancellationToken cancellationToken, Continuation continuation, Task task) {
        IIX0o.x0xO0oo(continuation, "$continuation");
        IIX0o.x0xO0oo(task, "task");
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.continueWithTask(continuation);
    }

    private final void runContinuations() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List<Continuation<TResult, Void>> list = this.continuations;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((Continuation) it.next()).then(this);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }
            }
            this.continuations = null;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setUnobservedExceptionHandler(@OXOo.oOoXoXO UnobservedExceptionHandler unobservedExceptionHandler2) {
        Companion.setUnobservedExceptionHandler(unobservedExceptionHandler2);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Task<Void> whenAll(@OXOo.OOXIXo Collection<? extends Task<?>> collection) {
        return Companion.whenAll(collection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<List<TResult>> whenAllResult(@OXOo.OOXIXo Collection<Task<TResult>> collection) {
        return Companion.whenAllResult(collection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Task<Task<?>> whenAny(@OXOo.OOXIXo Collection<? extends Task<?>> collection) {
        return Companion.whenAny(collection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<Task<TResult>> whenAnyResult(@OXOo.OOXIXo Collection<Task<TResult>> collection) {
        return Companion.whenAnyResult(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final <TOut> Task<TOut> cast() {
        return this;
    }

    @OXOo.OOXIXo
    public final Task<Void> continueWhile(@OXOo.OOXIXo Callable<Boolean> predicate, @OXOo.OOXIXo Continuation<Void, Task<Void>> continuation) {
        IIX0o.x0xO0oo(predicate, "predicate");
        IIX0o.x0xO0oo(continuation, "continuation");
        return continueWhile(predicate, continuation, IMMEDIATE_EXECUTOR, null);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@OXOo.OOXIXo Continuation<TResult, TContinuationResult> continuation, @OXOo.OOXIXo Executor executor) {
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return continueWith(continuation, executor, null);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@OXOo.OOXIXo Continuation<TResult, Task<TContinuationResult>> continuation, @OXOo.OOXIXo Executor executor) {
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return continueWithTask(continuation, executor, null);
    }

    @OXOo.oOoXoXO
    public final Exception getError() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.errorField != null) {
                this.errorHasBeenObserved = true;
                UnobservedErrorNotifier unobservedErrorNotifier = this.unobservedErrorNotifier;
                if (unobservedErrorNotifier != null) {
                    unobservedErrorNotifier.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            Exception exc = this.errorField;
            reentrantLock.unlock();
            return exc;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @OXOo.oOoXoXO
    public final TResult getResult() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.resultField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.cancelledField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCompleted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.completeField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isFaulted() {
        boolean z;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.errorField != null) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    @OXOo.OOXIXo
    public final Task<Void> makeVoid() {
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.oxoX
            @Override // com.facebook.bolts.Continuation
            public final Object then(Task task) {
                Task m181makeVoid$lambda8;
                m181makeVoid$lambda8 = Task.m181makeVoid$lambda8(task);
                return m181makeVoid$lambda8;
            }
        });
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@OXOo.OOXIXo Continuation<TResult, TContinuationResult> continuation, @OXOo.OOXIXo Executor executor) {
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return onSuccess(continuation, executor, null);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@OXOo.OOXIXo Continuation<TResult, Task<TContinuationResult>> continuation, @OXOo.OOXIXo Executor executor) {
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return onSuccessTask(continuation, executor, null);
    }

    public final boolean trySetCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                reentrantLock.unlock();
                return false;
            }
            this.completeField = true;
            this.cancelledField = true;
            this.condition.signalAll();
            runContinuations();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetError(@OXOo.oOoXoXO Exception exc) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.errorField = exc;
            this.errorHasBeenObserved = false;
            this.condition.signalAll();
            runContinuations();
            if (!this.errorHasBeenObserved && unobservedExceptionHandler != null) {
                this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetResult(@OXOo.oOoXoXO TResult tresult) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                reentrantLock.unlock();
                return false;
            }
            this.completeField = true;
            this.resultField = tresult;
            this.condition.signalAll();
            runContinuations();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void waitForCompletion() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await();
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        return Companion.call(callable, cancellationToken);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> callInBackground(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        return Companion.callInBackground(callable, cancellationToken);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Task<Void> delay(long j, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        return Companion.delay(j, cancellationToken);
    }

    @OXOo.OOXIXo
    public final Task<Void> continueWhile(@OXOo.OOXIXo Callable<Boolean> predicate, @OXOo.OOXIXo Continuation<Void, Task<Void>> continuation, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(predicate, "predicate");
        IIX0o.x0xO0oo(continuation, "continuation");
        return continueWhile(predicate, continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@OXOo.OOXIXo final Continuation<TResult, TContinuationResult> continuation, @OXOo.OOXIXo final Executor executor, @OXOo.oOoXoXO final CancellationToken cancellationToken) {
        List<Continuation<TResult, Void>> list;
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isCompleted = isCompleted();
            if (!isCompleted && (list = this.continuations) != null) {
                list.add(new Continuation() { // from class: com.facebook.bolts.I0Io
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        Void m179continueWith$lambda10$lambda9;
                        m179continueWith$lambda10$lambda9 = Task.m179continueWith$lambda10$lambda9(TaskCompletionSource.this, continuation, executor, cancellationToken, task);
                        return m179continueWith$lambda10$lambda9;
                    }
                });
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
            if (isCompleted) {
                Companion.completeImmediately(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@OXOo.OOXIXo final Continuation<TResult, Task<TContinuationResult>> continuation, @OXOo.OOXIXo final Executor executor, @OXOo.oOoXoXO final CancellationToken cancellationToken) {
        List<Continuation<TResult, Void>> list;
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isCompleted = isCompleted();
            if (!isCompleted && (list = this.continuations) != null) {
                list.add(new Continuation() { // from class: com.facebook.bolts.XO
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        Void m180continueWithTask$lambda12$lambda11;
                        m180continueWithTask$lambda12$lambda11 = Task.m180continueWithTask$lambda12$lambda11(TaskCompletionSource.this, continuation, executor, cancellationToken, task);
                        return m180continueWithTask$lambda12$lambda11;
                    }
                });
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
            if (isCompleted) {
                Companion.completeAfterTask(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@OXOo.OOXIXo final Continuation<TResult, TContinuationResult> continuation, @OXOo.OOXIXo Executor executor, @OXOo.oOoXoXO final CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.X0o0xo
            @Override // com.facebook.bolts.Continuation
            public final Object then(Task task) {
                Task m182onSuccess$lambda13;
                m182onSuccess$lambda13 = Task.m182onSuccess$lambda13(CancellationToken.this, continuation, task);
                return m182onSuccess$lambda13;
            }
        }, executor);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@OXOo.OOXIXo final Continuation<TResult, Task<TContinuationResult>> continuation, @OXOo.OOXIXo Executor executor, @OXOo.oOoXoXO final CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.II0xO0
            @Override // com.facebook.bolts.Continuation
            public final Object then(Task task) {
                Task m183onSuccessTask$lambda14;
                m183onSuccessTask$lambda14 = Task.m183onSuccessTask$lambda14(CancellationToken.this, continuation, task);
                return m183onSuccessTask$lambda14;
            }
        }, executor);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.OOXIXo Executor executor) {
        return Companion.call(callable, executor);
    }

    @OXOo.OOXIXo
    public final Task<Void> continueWhile(@OXOo.OOXIXo final Callable<Boolean> predicate, @OXOo.OOXIXo final Continuation<Void, Task<Void>> continuation, @OXOo.OOXIXo final Executor executor, @OXOo.oOoXoXO final CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(predicate, "predicate");
        IIX0o.x0xO0oo(continuation, "continuation");
        IIX0o.x0xO0oo(executor, "executor");
        return makeVoid().continueWithTask((Continuation<Void, Task<TContinuationResult>>) new Continuation<Void, Task<Void>>() { // from class: com.facebook.bolts.Task$continueWhile$predicateContinuation$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.bolts.Continuation
            @OXOo.OOXIXo
            public Task<Void> then(@OXOo.OOXIXo Task<Void> task) throws Exception {
                IIX0o.x0xO0oo(task, "task");
                CancellationToken cancellationToken2 = CancellationToken.this;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return Task.Companion.cancelled();
                }
                Boolean call = predicate.call();
                IIX0o.oO(call, "predicate.call()");
                if (call.booleanValue()) {
                    return Task.Companion.forResult(null).onSuccessTask(continuation, executor).onSuccessTask(this, executor);
                }
                return Task.Companion.forResult(null);
            }
        }, executor);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <TResult> Task<TResult> call(@OXOo.OOXIXo Callable<TResult> callable, @OXOo.OOXIXo Executor executor, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        return Companion.call(callable, executor, cancellationToken);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@OXOo.OOXIXo Continuation<TResult, TContinuationResult> continuation) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@OXOo.OOXIXo Continuation<TResult, Task<TContinuationResult>> continuation) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR);
    }

    private Task(TResult tresult) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
        trySetResult(tresult);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@OXOo.OOXIXo Continuation<TResult, TContinuationResult> continuation, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@OXOo.OOXIXo Continuation<TResult, Task<TContinuationResult>> continuation, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final boolean waitForCompletion(long j, @OXOo.OOXIXo TimeUnit timeUnit) throws InterruptedException {
        IIX0o.x0xO0oo(timeUnit, "timeUnit");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await(j, timeUnit);
            }
            boolean isCompleted = isCompleted();
            reentrantLock.unlock();
            return isCompleted;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private Task(boolean z) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
        if (z) {
            trySetCancelled();
        } else {
            trySetResult(null);
        }
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@OXOo.OOXIXo Continuation<TResult, TContinuationResult> continuation) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@OXOo.OOXIXo Continuation<TResult, Task<TContinuationResult>> continuation) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@OXOo.OOXIXo Continuation<TResult, TContinuationResult> continuation, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    @OXOo.OOXIXo
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@OXOo.OOXIXo Continuation<TResult, Task<TContinuationResult>> continuation, @OXOo.oOoXoXO CancellationToken cancellationToken) {
        IIX0o.x0xO0oo(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }
}
