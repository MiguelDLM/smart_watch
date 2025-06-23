package com.goodix.ble.libcomx.task;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.annotation.Nullable;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.task.TaskError;
import com.goodix.ble.libcomx.util.CallUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public abstract class Task implements ITask, ITaskResult {
    protected static final int STATE_FINISHED = 4;
    protected static final int STATE_IDLE = 0;
    protected static final int STATE_RUNNING = 2;
    protected static final int STATE_STARTING = 1;
    protected static final int STATE_STOPPING = 3;
    private static final int TIMER_ID_TASK_TIME_OUT = -277;
    public static ILogger debugLogger;
    private boolean clearListenerAfterFinished;
    private boolean debounceProgressEvent;

    @Nullable
    private HashMap<String, Object> envParameter;
    private final Event<ITaskResult> eventFinish;
    private final Event<Integer> eventProgress;
    private final Event<Void> eventStart;
    private boolean hasRun;
    protected boolean isAborted;
    private boolean isFinished;
    private int lastPublishedPercent;

    @TaskParameter(nullable = true)
    protected ILogger logger;
    private Executor mExecutor;

    @Nullable
    private Timer mTimer;
    protected ITask prevTask;
    protected boolean printVerboseLog;
    private final boolean reusableTask;
    protected ITaskContext rootCtx;
    private String taskName;
    private boolean taskPending;
    private int taskResultCode;
    private TaskError taskResultError;
    protected int taskState;
    private long timeoutInterval;
    private long timeoutTimeStamp;

    public Task() {
        this.taskName = getClass().getSimpleName();
        this.logger = debugLogger;
        this.isAborted = false;
        this.isFinished = false;
        this.hasRun = false;
        this.debounceProgressEvent = false;
        this.taskState = 0;
        this.eventStart = new Event<>(this, ITask.EVT_START);
        this.eventProgress = new Event<>(this, 341);
        this.eventFinish = new Event<>(this, ITask.EVT_FINISH);
        this.clearListenerAfterFinished = false;
        this.printVerboseLog = debugLogger != null;
        this.envParameter = null;
        this.taskPending = false;
        this.timeoutInterval = 0L;
        this.timeoutTimeStamp = 0L;
        this.reusableTask = true;
    }

    private TaskError initializeParameter() {
        for (Class<?> cls = getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                TaskParameter taskParameter = (TaskParameter) field.getAnnotation(TaskParameter.class);
                if (taskParameter != null) {
                    try {
                        Object parameter = getParameter(field.getType().getName());
                        if (parameter == null) {
                            parameter = getOutput(field.getType().getName());
                        }
                        field.setAccessible(true);
                        if (parameter != null) {
                            field.set(this, parameter);
                            ILogger iLogger = this.logger;
                            if (iLogger != null && this.printVerboseLog) {
                                iLogger.v(getName(), "Acquire parameter: " + field.getName() + " = " + parameter);
                            }
                        } else if (field.get(this) == null && !taskParameter.nullable()) {
                            return new TaskError(this, "Parameter " + field.getName() + " is null.");
                        }
                    } catch (IllegalAccessException e) {
                        return new TaskError(this, "Failed to set parameter " + field.getName(), e);
                    }
                }
            }
            if (cls == Task.class) {
                return null;
            }
        }
        return null;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public void abort() {
        boolean z;
        int i;
        synchronized (this) {
            try {
                if (!this.isAborted && ((i = this.taskState) == 2 || i == 1)) {
                    this.isAborted = true;
                    if (i == 2) {
                        z = this.taskPending;
                    }
                }
                z = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            finished(-2, new TaskError.Abort(this));
        }
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public ITask clearListener(Object obj) {
        this.eventStart.clear(obj);
        this.eventProgress.clear(obj);
        this.eventFinish.clear(obj);
        return this;
    }

    public abstract int doWork();

    @Override // com.goodix.ble.libcomx.task.ITask
    public final Event<ITaskResult> evtFinished() {
        return this.eventFinish;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public final Event<Integer> evtProgress() {
        return this.eventProgress;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public final Event<Void> evtStart() {
        return this.eventStart;
    }

    public final synchronized void finished(int i, TaskError taskError) {
        synchronized (this) {
            try {
                if (this.taskState != 2) {
                    ILogger iLogger = this.logger;
                    if (iLogger != null) {
                        iLogger.w(getName(), "Task is not running. Do not call finished() again with: resultCode = [" + i + "], e = [" + taskError + "], from " + CallUtil.trace(5));
                    }
                    return;
                }
                this.taskState = 3;
                this.taskPending = false;
                this.isFinished = true;
                this.taskResultCode = i;
                this.taskResultError = taskError;
                ILogger iLogger2 = this.logger;
                TaskError taskError2 = taskError;
                if (iLogger2 != null) {
                    if (taskError == null) {
                        if (this.printVerboseLog) {
                            iLogger2.v(getName(), "finished with: resultCode = [" + i + "]");
                        }
                    } else {
                        while (taskError2.getCause() != null) {
                            taskError2 = taskError2.getCause();
                        }
                        this.logger.e(getName(), "finished with: resultCode = [" + i + "], rootCause = [" + taskError2.getMessage() + "]");
                    }
                }
                try {
                    stopTimer();
                    onCleanup();
                    this.eventFinish.postEvent(this);
                } catch (Exception e) {
                    synchronized (this) {
                        String str = "Error is occurred while exiting: " + e.getMessage();
                        this.taskResultCode = -1;
                        this.taskResultError = new TaskError(this, str, e);
                        try {
                            this.eventFinish.postEvent(this);
                        } catch (Exception e2) {
                            ILogger iLogger3 = this.logger;
                            if (iLogger3 != null) {
                                iLogger3.e(getName(), "Error is occurred in Finish Event: " + e2.getMessage(), e2);
                            } else {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (this.clearListenerAfterFinished || !this.reusableTask) {
                    clearListener(null);
                }
                synchronized (this) {
                    try {
                        if (this.reusableTask) {
                            this.taskState = 0;
                        } else {
                            this.taskState = 4;
                        }
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public final void finishedWithDone() {
        finished(0, null);
    }

    public final void finishedWithError(int i, String str) {
        finished(i, new TaskError(this, str));
    }

    @Override // com.goodix.ble.libcomx.task.ITaskResult
    public int getCode() {
        return this.taskResultCode;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskResult
    public TaskError getError() {
        return this.taskResultError;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskContext
    public final Executor getExecutor() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            ITaskContext iTaskContext = this.rootCtx;
            if (iTaskContext != null) {
                executor = iTaskContext.getExecutor();
            }
            if (executor == null) {
                ITask iTask = this.prevTask;
                if (iTask != null) {
                    synchronized (this) {
                        this.prevTask = null;
                        executor = iTask.getExecutor();
                        this.prevTask = iTask;
                    }
                }
                if (executor == null) {
                    synchronized (this) {
                        try {
                            if (this.mExecutor == null) {
                                this.mExecutor = TaskExecutor.getDefaultExecutor();
                            }
                            executor = this.mExecutor;
                        } finally {
                        }
                    }
                }
            }
        }
        return executor;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public ILogger getLogger() {
        return this.logger;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public String getName() {
        return this.taskName;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public final synchronized <T> T getOutput(String str) {
        T t;
        try {
            HashMap<String, Object> hashMap = this.envParameter;
            if (hashMap != null) {
                t = (T) hashMap.get(str);
            } else {
                t = null;
            }
            ITask iTask = this.prevTask;
            if (t == null && iTask != null) {
                this.prevTask = null;
                t = (T) iTask.getOutput(str);
                this.prevTask = iTask;
            }
        } catch (Throwable th) {
            throw th;
        }
        return t;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskContext
    public final synchronized <T> T getParameter(String str) {
        T t;
        HashMap<String, Object> hashMap;
        try {
            ITaskContext iTaskContext = this.rootCtx;
            if (iTaskContext != null) {
                t = (T) iTaskContext.getParameter(str);
            } else {
                t = null;
            }
            if (t == null && (hashMap = this.envParameter) != null) {
                t = (T) hashMap.get(str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return t;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public <T> T getPreviousTask() {
        try {
            return (T) this.prevTask;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public int getProgress() {
        int i = this.lastPublishedPercent;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public ITaskResult getResult() {
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskResult
    public ITask getTask() {
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public boolean isFinished() {
        return this.isFinished;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public boolean isStarted() {
        if (this.taskState == 2) {
            return true;
        }
        return false;
    }

    public void onCleanup() {
    }

    public void onStart() {
    }

    public void onTaskExpired() {
    }

    public void onTimeout(int i) {
    }

    public final void publishProgress(int i) {
        ILogger iLogger = this.logger;
        synchronized (this) {
            try {
                if (this.taskState == 2 && !this.isAborted) {
                    if (iLogger != null && this.printVerboseLog) {
                        iLogger.v(getName(), "publishProgress: " + i);
                    }
                    if (this.timeoutInterval > 0) {
                        this.timeoutTimeStamp = System.currentTimeMillis() + this.timeoutInterval;
                    }
                    boolean z = true;
                    if (this.debounceProgressEvent && this.lastPublishedPercent == i) {
                        z = false;
                    }
                    this.lastPublishedPercent = i;
                    if (z) {
                        this.eventProgress.postEvent(Integer.valueOf(i));
                    }
                }
            } finally {
            }
        }
    }

    public final synchronized void refreshTaskTimeout() {
        if (this.taskState == 2 && this.timeoutInterval > 0) {
            this.timeoutTimeStamp = System.currentTimeMillis() + this.timeoutInterval;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILogger iLogger = this.logger;
        synchronized (this) {
            try {
                if (this.taskState != 2) {
                    if (iLogger != null) {
                        iLogger.w(getName(), "Task is not running. Unexpected executor schedule.");
                    }
                    return;
                }
                if (this.hasRun) {
                    if (iLogger != null) {
                        iLogger.w(getName(), "Task is pending. Unexpected executor schedule.");
                    }
                    return;
                }
                boolean z = true;
                this.hasRun = true;
                if (this.taskPending) {
                    if (iLogger != null) {
                        iLogger.w(getName(), "Task is pending. Unexpected executor schedule.");
                    }
                    return;
                }
                boolean z2 = this.isAborted;
                if (z2) {
                    finished(-2, new TaskError.Abort(this));
                    return;
                }
                try {
                    int doWork = doWork();
                    synchronized (this) {
                        try {
                            if (this.taskState == 2) {
                                if (this.isAborted) {
                                    z2 = true;
                                } else if (doWork > 0) {
                                    this.taskPending = true;
                                    this.timeoutInterval = doWork;
                                    this.timeoutTimeStamp = System.currentTimeMillis() + this.timeoutInterval;
                                }
                            } else {
                                doWork = 0;
                            }
                        } finally {
                        }
                    }
                    if (z2) {
                        finished(-2, new TaskError.Abort(this));
                        return;
                    }
                    if (doWork > 0) {
                        startTimer(TIMER_ID_TASK_TIME_OUT, doWork);
                        if (iLogger != null && this.printVerboseLog) {
                            iLogger.v(getName(), "Pend task for waiting some callbacks.");
                        }
                    }
                    synchronized (this) {
                        try {
                            if (this.taskState != 2 || this.taskPending) {
                                z = false;
                            }
                        } finally {
                        }
                    }
                    if (z) {
                        if (iLogger != null && this.printVerboseLog) {
                            iLogger.v(getName(), "Call finished() automatically for sync task.");
                        }
                        finishedWithDone();
                    }
                } catch (Throwable th) {
                    finishedWithError("Exception is occurred while running.", th);
                }
            } finally {
            }
        }
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public ITask setDebug(boolean z) {
        this.printVerboseLog = z;
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public ITask setLogger(ILogger iLogger) {
        this.logger = iLogger;
        return this;
    }

    public final Task setOneshot(boolean z) {
        this.clearListenerAfterFinished = z;
        return this;
    }

    public final Task setParameter(Class cls, Object obj) {
        setParameter(cls.getName(), (String) obj);
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public final void start(ITaskContext iTaskContext, ITask iTask) {
        ILogger iLogger = this.logger;
        synchronized (this) {
            try {
                int i = this.taskState;
                if (i != 0) {
                    if (iLogger != null) {
                        if (i == 4) {
                            iLogger.e(getName(), "The task is disposable and finished. It can NOT be started again. From " + CallUtil.trace(5));
                        } else {
                            iLogger.w(getName(), "The task is not idle. DO NOT call start() again, from " + CallUtil.trace(5));
                        }
                    }
                    return;
                }
                this.taskState = 1;
                this.isFinished = false;
                this.isAborted = false;
                this.lastPublishedPercent = -1;
                this.taskResultCode = 0;
                this.taskResultError = null;
                onStart();
                if (iTaskContext != this) {
                    this.rootCtx = iTaskContext;
                }
                if (iTask != this) {
                    this.prevTask = iTask;
                }
                TaskError initializeParameter = initializeParameter();
                if (iLogger != null && this.printVerboseLog) {
                    iLogger.v(getName(), "Started");
                }
                this.eventStart.postEvent(null);
                synchronized (this) {
                    this.taskState = 2;
                    this.hasRun = false;
                }
                if (initializeParameter != null) {
                    finished(-1, initializeParameter);
                } else if (this.isAborted) {
                    finished(-2, new TaskError.Abort(this));
                } else {
                    getExecutor().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized TimerTask startTimer(final int i, long j, long j2) {
        try {
            if (this.taskState != 2) {
                return null;
            }
            if (this.mTimer == null) {
                this.mTimer = new Timer();
            }
            TimerTask timerTask = new TimerTask() { // from class: com.goodix.ble.libcomx.task.Task.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Task.this.getExecutor().execute(new Runnable() { // from class: com.goodix.ble.libcomx.task.Task.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Task.this.isFinished) {
                                return;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            int i2 = i;
                            if (i2 == Task.TIMER_ID_TASK_TIME_OUT) {
                                if (System.currentTimeMillis() < Task.this.timeoutTimeStamp) {
                                    Task task = Task.this;
                                    task.startTimer(Task.TIMER_ID_TASK_TIME_OUT, task.timeoutTimeStamp - System.currentTimeMillis());
                                    return;
                                } else {
                                    Task.this.onTaskExpired();
                                    if (!Task.this.isFinished) {
                                        Task.this.finished(-3, new TaskError.Timeout(Task.this));
                                        return;
                                    }
                                    return;
                                }
                            }
                            try {
                                Task.this.onTimeout(i2);
                            } catch (Exception e) {
                                Task.this.finishedWithError("Exception in onTimer().", e);
                            }
                        }
                    });
                }
            };
            if (j2 > 0) {
                this.mTimer.scheduleAtFixedRate(timerTask, j, j2);
            } else {
                this.mTimer.schedule(timerTask, j);
            }
            return timerTask;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    public final void finishedWithError(int i, String str, Throwable th) {
        finished(i, new TaskError(this, str, th));
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public final Task setDebounceProgressEvent(boolean z) {
        this.debounceProgressEvent = z;
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public final Task setExecutor(Executor executor) {
        this.mExecutor = executor;
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.ITask
    public Task setName(String str) {
        this.taskName = str;
        return this;
    }

    public final Task setParameter(ITaskParameter iTaskParameter) {
        setParameter(iTaskParameter.getClass().getName(), (String) iTaskParameter);
        return this;
    }

    public final void finishedWithError(String str) {
        finished(-1, new TaskError(this, str));
    }

    @Override // com.goodix.ble.libcomx.task.ITaskContext
    public final synchronized <T> void setParameter(String str, T t) {
        try {
            if (this.envParameter == null) {
                this.envParameter = new HashMap<>();
            }
            this.envParameter.put(str, t);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void finishedWithError(String str, Throwable th) {
        finished(-1, new TaskError(this, str, th));
    }

    public final TimerTask startTimer(int i, long j) {
        return startTimer(i, j, 0L);
    }

    public Task(String str) {
        this.taskName = getClass().getSimpleName();
        this.logger = debugLogger;
        this.isAborted = false;
        this.isFinished = false;
        this.hasRun = false;
        this.debounceProgressEvent = false;
        this.taskState = 0;
        this.eventStart = new Event<>(this, ITask.EVT_START);
        this.eventProgress = new Event<>(this, 341);
        this.eventFinish = new Event<>(this, ITask.EVT_FINISH);
        this.clearListenerAfterFinished = false;
        this.printVerboseLog = debugLogger != null;
        this.envParameter = null;
        this.taskPending = false;
        this.timeoutInterval = 0L;
        this.timeoutTimeStamp = 0L;
        this.taskName = str;
        this.reusableTask = true;
    }

    public Task(boolean z) {
        this.taskName = getClass().getSimpleName();
        this.logger = debugLogger;
        this.isAborted = false;
        this.isFinished = false;
        this.hasRun = false;
        this.debounceProgressEvent = false;
        this.taskState = 0;
        this.eventStart = new Event<>(this, ITask.EVT_START);
        this.eventProgress = new Event<>(this, 341);
        this.eventFinish = new Event<>(this, ITask.EVT_FINISH);
        this.clearListenerAfterFinished = false;
        this.printVerboseLog = debugLogger != null;
        this.envParameter = null;
        this.taskPending = false;
        this.timeoutInterval = 0L;
        this.timeoutTimeStamp = 0L;
        this.reusableTask = z;
    }
}
