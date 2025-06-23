package com.goodix.ble.libcomx.task;

import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public class TaskPipe implements ITaskContext, IEventListener {
    public static final int EVT_BUSY = 761;
    public static final int EVT_TASK_ADDED = 447;
    public static final int EVT_TASK_PROGRESS = 938;
    public static final int EVT_TASK_REMOVED = 166;
    public static final int EVT_TASK_START = 138;
    private Executor executor;
    private boolean isBusy;
    private final Event<Boolean> eventBusy = new Event<>(this, EVT_BUSY);
    private final Event<TaskItem> eventTaskAdded = new Event<>(this, EVT_TASK_ADDED);
    private final Event<TaskItem> eventTaskStart = new Event<>(this, 138);
    private final Event<TaskItem> eventTaskProgress = new Event<>(this, EVT_TASK_PROGRESS);
    private final Event<TaskItem> eventTaskRemoved = new Event<>(this, 166);
    private LinkedList<TaskItem> taskList = new LinkedList<>();
    private HashMap<String, Object> parameters = new HashMap<>();

    /* loaded from: classes9.dex */
    public static class TaskItem {
        public String name;
        public int percent;
        public ITaskResult result;
        public ITask task;
    }

    private void startNextTask(ITask iTask) {
        TaskItem peekFirst = this.taskList.peekFirst();
        if (peekFirst != null) {
            this.eventTaskStart.postEvent(peekFirst);
            peekFirst.task.evtStart().register(this);
            peekFirst.task.evtProgress().register(this);
            peekFirst.task.evtFinished().register(this);
            peekFirst.task.start(this, iTask);
            return;
        }
        this.isBusy = false;
        this.eventBusy.postEvent(Boolean.FALSE);
    }

    public synchronized void abortTask() {
        TaskItem peekFirst;
        if (!this.taskList.isEmpty() && (peekFirst = this.taskList.peekFirst()) != null) {
            peekFirst.task.abort();
        }
    }

    public void addTask(ITask iTask) {
        addTask(iTask, null);
    }

    public synchronized void clearTask() {
        try {
            if (!this.taskList.isEmpty()) {
                while (this.taskList.size() > 0) {
                    this.taskList.removeLast().task.abort();
                }
                if (this.isBusy) {
                    this.isBusy = false;
                    this.eventBusy.postEvent(Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Event<Boolean> evtBusy() {
        return this.eventBusy;
    }

    public Event<TaskItem> evtTaskAdded() {
        return this.eventTaskAdded;
    }

    public Event<TaskItem> evtTaskProgress() {
        return this.eventTaskProgress;
    }

    public Event<TaskItem> evtTaskRemoved() {
        return this.eventTaskRemoved;
    }

    public Event<TaskItem> evtTaskStart() {
        return this.eventTaskStart;
    }

    public synchronized ITask getCurrentTask() {
        TaskItem peekFirst = this.taskList.peekFirst();
        if (peekFirst != null) {
            return peekFirst.task;
        }
        return null;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskContext
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskContext
    public <T> T getParameter(String str) {
        return (T) this.parameters.get(str);
    }

    public synchronized int getTaskCount() {
        return this.taskList.size();
    }

    public synchronized List<ITask> getTaskList(List<ITask> list) {
        if (list == null) {
            try {
                list = new ArrayList<>(this.taskList.size());
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator<TaskItem> it = this.taskList.iterator();
        while (it.hasNext()) {
            list.add(it.next().task);
        }
        return list;
    }

    public boolean isBusy() {
        return this.isBusy;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        TaskItem peekFirst;
        TaskItem peekFirst2;
        ITask iTask;
        if (i == 342) {
            synchronized (this) {
                peekFirst2 = this.taskList.peekFirst();
            }
            if (peekFirst2 != null && obj == (iTask = peekFirst2.task)) {
                iTask.evtStart().remove(this);
                peekFirst2.task.evtProgress().remove(this);
                peekFirst2.task.evtFinished().remove(this);
                peekFirst2.result = (ITaskResult) obj2;
                this.eventTaskRemoved.postEvent(peekFirst2);
                synchronized (this) {
                    startNextTask(this.taskList.removeFirst().task);
                }
                return;
            }
            return;
        }
        if (i == 341) {
            synchronized (this) {
                peekFirst = this.taskList.peekFirst();
            }
            if (peekFirst != null && obj == peekFirst.task) {
                peekFirst.percent = ((Integer) obj2).intValue();
                this.eventTaskProgress.postEvent(peekFirst);
            }
        }
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override // com.goodix.ble.libcomx.task.ITaskContext
    public <T> void setParameter(String str, T t) {
        this.parameters.put(str, t);
    }

    public synchronized void addTask(ITask iTask, String str) {
        if (iTask == null) {
            return;
        }
        try {
            if (!this.isBusy) {
                this.isBusy = true;
                this.eventBusy.postEvent(Boolean.TRUE);
            }
            TaskItem taskItem = new TaskItem();
            taskItem.task = iTask;
            if (str == null) {
                str = iTask.getName();
            }
            taskItem.name = str;
            this.taskList.add(taskItem);
            this.eventTaskAdded.postEvent(taskItem);
            if (this.taskList.size() == 1) {
                startNextTask(null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
