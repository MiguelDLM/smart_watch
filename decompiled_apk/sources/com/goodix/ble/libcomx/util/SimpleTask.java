package com.goodix.ble.libcomx.util;

import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskError;

/* loaded from: classes9.dex */
public class SimpleTask extends Task {
    private Object tag;
    private int taskId;
    private Work work;

    /* loaded from: classes9.dex */
    public interface Work {
        void onWork(SimpleTask simpleTask, Object obj) throws Throwable;
    }

    public SimpleTask() {
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        TaskError taskError;
        Work work = this.work;
        if (work != null) {
            try {
                work.onWork(this, this.tag);
                return 0;
            } catch (Throwable th) {
                if (th instanceof TaskError) {
                    taskError = th;
                } else {
                    taskError = new TaskError(this, th.getMessage(), th);
                }
                finished(-1, taskError);
                return 0;
            }
        }
        return 0;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public SimpleTask setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public SimpleTask setTaskId(int i) {
        this.taskId = i;
        return this;
    }

    public SimpleTask setWork(Work work) {
        this.work = work;
        return this;
    }

    public SimpleTask(Work work) {
        this.work = work;
    }

    public SimpleTask(String str, Object obj, Work work) {
        this.work = work;
        this.tag = obj;
        setName(str);
        if (obj instanceof Integer) {
            this.taskId = ((Integer) obj).intValue();
        }
    }
}
