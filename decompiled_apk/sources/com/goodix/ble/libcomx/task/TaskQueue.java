package com.goodix.ble.libcomx.task;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class TaskQueue extends Task implements ITaskSet {
    private ITask currentTask;
    private int currentTaskPos;
    protected boolean abortOnException = false;
    protected boolean useResultOfSubtask = false;
    protected boolean requestAbortQueue = false;
    private List<ITask> mTaskContextList = new ArrayList();
    private int[] mTaskPercentWeights = null;
    private Event<ITask> eventSubtaskStart = new Event<>(this, ITaskSet.EVT_SUBTASK_START);
    private Event<ITask> eventSubtaskProgress = new Event<>(this, ITaskSet.EVT_SUBTASK_PROGRESS);
    private Event<ITask> eventSubtaskFinish = new Event<>(this, ITaskSet.EVT_SUBTASK_FINISH);
    private SubTaskListener subTaskEventHandler = new SubTaskListener();
    private int queueTimeout = x.ac;

    /* loaded from: classes9.dex */
    public class SubTaskListener implements IEventListener {
        public SubTaskListener() {
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        public void onEvent(Object obj, int i, Object obj2) {
            ITask iTask;
            int i2;
            TaskQueue taskQueue = TaskQueue.this;
            ILogger iLogger = taskQueue.logger;
            ITask iTask2 = (ITask) obj;
            synchronized (taskQueue) {
                iTask = TaskQueue.this.currentTask;
                i2 = TaskQueue.this.currentTaskPos;
            }
            if (iTask2 == iTask) {
                if (i == 340) {
                    TaskQueue.this.publishWithChildProgress(0);
                    TaskQueue.this.eventSubtaskStart.postEvent(iTask2);
                    return;
                }
                if (i == 341) {
                    TaskQueue.this.publishWithChildProgress(((Integer) obj2).intValue());
                    TaskQueue.this.eventSubtaskProgress.postEvent(iTask2);
                    return;
                }
                if (i == 342) {
                    ITaskResult iTaskResult = (ITaskResult) obj2;
                    if (iLogger != null && TaskQueue.this.printVerboseLog) {
                        if (iTaskResult.getError() != null) {
                            iLogger.v(TaskQueue.this.getName(), "Subtask #" + i2 + ", " + iTask2.getName() + ", is finished with error: " + iTaskResult.getError().getMessage() + ". Start next one.");
                        } else {
                            iLogger.v(TaskQueue.this.getName(), "Subtask #" + i2 + ", " + iTask2.getName() + ", is finished. Start next one.");
                        }
                    }
                    iTask2.evtStart().remove(TaskQueue.this.subTaskEventHandler);
                    iTask2.evtProgress().remove(TaskQueue.this.subTaskEventHandler);
                    iTask2.evtFinished().remove(TaskQueue.this.subTaskEventHandler);
                    TaskQueue.this.eventSubtaskFinish.postEvent(iTask2);
                    TaskQueue.this.tryStartNextTask();
                    return;
                }
                return;
            }
            if (iLogger != null) {
                iLogger.w(TaskQueue.this.getName(), "Unexpected event: src = " + iTask2.getName() + ", type = " + i + ", data = " + obj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishWithChildProgress(int i) {
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            try {
                int i5 = this.currentTaskPos;
                int size = this.mTaskContextList.size();
                int[] iArr = this.mTaskPercentWeights;
                i2 = 0;
                if (iArr != null) {
                    i3 = 0;
                    for (int i6 = 0; i6 < i5; i6++) {
                        i3 += iArr[i6];
                    }
                    i4 = iArr[i5];
                } else {
                    i3 = (i5 * 100) / size;
                    i4 = 100 / size;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i > 100) {
            i = 100;
        }
        if (i >= 0) {
            i2 = i;
        }
        publishProgress(i3 + ((i4 * i2) / 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleTask() {
        try {
            if (this.taskState != 2) {
                return;
            }
            ILogger iLogger = this.logger;
            int size = this.mTaskContextList.size();
            int i = this.currentTaskPos + 1;
            this.currentTaskPos = i;
            if (i < size) {
                ITask iTask = this.currentTask;
                if (iTask == null) {
                    iTask = this.prevTask;
                }
                this.currentTask = this.mTaskContextList.get(i);
                if (iLogger != null) {
                    try {
                        if (this.printVerboseLog) {
                            iLogger.v(getName(), "Start subtask #" + i + ": " + this.currentTask.getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        String str = "Exception on starting subtask #" + this.currentTaskPos + ", " + this.currentTask.getName() + ": " + e.getMessage();
                        if (this.abortOnException) {
                            finished(-1, new TaskError(this, str, e));
                        } else {
                            if (iLogger != null) {
                                iLogger.e(getName(), str);
                            }
                            tryStartNextTask();
                        }
                    }
                }
                this.currentTask.evtFinished().register(this.subTaskEventHandler);
                this.currentTask.evtProgress().register(this.subTaskEventHandler);
                this.currentTask.evtStart().register(this.subTaskEventHandler);
                this.currentTask.start(this, iTask);
            } else {
                finishedWithDone();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryStartNextTask() {
        boolean z;
        ITask iTask;
        int i;
        synchronized (this) {
            try {
                if (this.taskState == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.abortOnException) {
                    iTask = this.currentTask;
                    i = this.currentTaskPos;
                } else {
                    iTask = null;
                    i = -1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            if (iTask != null) {
                ITaskResult result = iTask.getResult();
                if (result.getError() != null) {
                    if (this.useResultOfSubtask) {
                        finished(result.getCode(), result.getError());
                        return;
                    }
                    finished(-1, new TaskError(this, "Abort at subtask #" + i + ": " + iTask.getName(), result.getError()));
                    return;
                }
            }
            getExecutor().execute(new Runnable() { // from class: com.goodix.ble.libcomx.task.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    TaskQueue.this.scheduleTask();
                }
            });
        }
    }

    public synchronized TaskQueue addTask(ITask iTask) {
        if (!isStarted()) {
            this.mTaskContextList.add(iTask);
        } else {
            throw new IllegalStateException("Task is already started.");
        }
        return this;
    }

    public <T extends ITask> T addTask2(T t) {
        addTask(t);
        return t;
    }

    @Override // com.goodix.ble.libcomx.task.Task, com.goodix.ble.libcomx.task.ITask
    public ITask clearListener(Object obj) {
        evtSubtaskStart().clear(obj);
        evtSubtaskProgress().clear(obj);
        evtSubtaskFinish().clear(obj);
        return super.clearListener(obj);
    }

    public synchronized TaskQueue clearTask() {
        try {
            if (!isStarted()) {
                for (ITask iTask : this.mTaskContextList) {
                    iTask.evtFinished().remove(this.subTaskEventHandler);
                    iTask.evtProgress().remove(this.subTaskEventHandler);
                    iTask.evtStart().remove(this.subTaskEventHandler);
                }
                this.mTaskContextList.clear();
            } else {
                throw new IllegalStateException("Task is already started.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        int[] iArr = this.mTaskPercentWeights;
        if (iArr != null && iArr.length != this.mTaskContextList.size()) {
            finishedWithError("Must set weight for each subtask.");
            return 0;
        }
        scheduleTask();
        return this.queueTimeout;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskSet
    public Event<ITask> evtSubtaskFinish() {
        return this.eventSubtaskFinish;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskSet
    public Event<ITask> evtSubtaskProgress() {
        return this.eventSubtaskProgress;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskSet
    public Event<ITask> evtSubtaskStart() {
        return this.eventSubtaskStart;
    }

    public synchronized ITask getTask(int i) {
        int size = this.mTaskContextList.size();
        if (i < 0 && (i = i + size) < 0) {
            i = 0;
        }
        if (i < size) {
            return this.mTaskContextList.get(i);
        }
        return null;
    }

    public synchronized int getTaskCount() {
        return this.mTaskContextList.size();
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        ITask iTask = this.currentTask;
        if (iTask != null) {
            iTask.abort();
        }
        this.requestAbortQueue = true;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onStart() {
        this.currentTask = null;
        this.currentTaskPos = -1;
        this.requestAbortQueue = false;
    }

    public synchronized ITask replaceTask(int i, ITask iTask) {
        int size = this.mTaskContextList.size();
        if (i < 0 && (i = i + size) < 0) {
            i = 0;
        }
        if (i < size) {
            ITask iTask2 = this.mTaskContextList.get(i);
            this.mTaskContextList.set(i, iTask);
            return iTask2;
        }
        return null;
    }

    public TaskQueue setAbortOnException() {
        this.abortOnException = true;
        return this;
    }

    @Override // com.goodix.ble.libcomx.task.Task, com.goodix.ble.libcomx.task.ITask
    public ITask setDebug(boolean z) {
        synchronized (this) {
            try {
                Iterator<ITask> it = this.mTaskContextList.iterator();
                while (it.hasNext()) {
                    it.next().setDebug(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.setDebug(z);
    }

    @Override // com.goodix.ble.libcomx.task.Task, com.goodix.ble.libcomx.task.ITask
    public ITask setLogger(ILogger iLogger) {
        super.setLogger(iLogger);
        synchronized (this) {
            try {
                Iterator<ITask> it = this.mTaskContextList.iterator();
                while (it.hasNext()) {
                    it.next().setLogger(iLogger);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public TaskQueue setQueueTimeout(int i) {
        this.queueTimeout = i;
        return this;
    }

    public TaskQueue setTaskPercentWeights(int... iArr) {
        if (iArr != null && iArr.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 > 0) {
                    i += i3;
                } else {
                    throw new IllegalArgumentException("Weight of subtask must > 0 at [" + i2 + "]: " + i3);
                }
            }
            if (i == 100) {
                this.mTaskPercentWeights = iArr;
            } else {
                throw new IllegalArgumentException("Expected total weight is 100, but actual weight is: " + i);
            }
        } else {
            this.mTaskPercentWeights = null;
        }
        return this;
    }

    public TaskQueue setAbortOnException(boolean z) {
        this.abortOnException = true;
        this.useResultOfSubtask = z;
        return this;
    }
}
