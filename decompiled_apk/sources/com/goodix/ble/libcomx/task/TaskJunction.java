package com.goodix.ble.libcomx.task;

import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;

/* loaded from: classes9.dex */
public class TaskJunction implements IEventListener {
    private boolean isOneshot;
    private ITask nextTask;
    private Event srcEvt;
    private boolean startIfError = false;
    private boolean startIfCode = false;
    private int expectTaskResultCode = 0;

    private TaskJunction() {
    }

    public static TaskJunction link(Event event, ITask iTask) {
        TaskJunction taskJunction = new TaskJunction();
        taskJunction.srcEvt = event;
        event.register(taskJunction);
        taskJunction.nextTask = iTask;
        return taskJunction;
    }

    public void destroy() {
        this.srcEvt.remove(this);
        this.srcEvt = null;
        this.nextTask = null;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    @Deprecated
    public void onEvent(Object obj, int i, Object obj2) {
        ITaskContext iTaskContext;
        boolean z;
        ITask iTask = null;
        if (obj instanceof ITask) {
            iTask = (ITask) obj;
            iTaskContext = null;
        } else if (obj instanceof ITaskContext) {
            iTaskContext = (ITaskContext) obj;
        } else {
            iTaskContext = null;
        }
        boolean z2 = true;
        if (i == 342 && (obj2 instanceof ITaskResult)) {
            ITaskResult iTaskResult = (ITaskResult) obj2;
            if (this.startIfError && iTaskResult.getError() == null) {
                z = false;
            } else {
                z = true;
            }
            if (this.startIfCode) {
                if (iTaskResult.getCode() != this.expectTaskResultCode) {
                    z2 = false;
                }
            } else {
                z2 = z;
            }
        }
        if (z2) {
            if (this.isOneshot) {
                destroy();
            }
            this.nextTask.start(iTaskContext, iTask);
        }
    }

    public TaskJunction setOneshot(boolean z) {
        this.isOneshot = z;
        return this;
    }

    public TaskJunction setStartIfCode(int i) {
        this.startIfCode = true;
        this.expectTaskResultCode = i;
        return this;
    }

    public TaskJunction setStartIfError() {
        this.startIfError = true;
        return this;
    }

    public static TaskJunction link(ITask iTask, ITask iTask2) {
        TaskJunction taskJunction = new TaskJunction();
        Event<ITaskResult> evtFinished = iTask.evtFinished();
        taskJunction.srcEvt = evtFinished;
        evtFinished.register(taskJunction);
        taskJunction.nextTask = iTask2;
        return taskJunction;
    }
}
