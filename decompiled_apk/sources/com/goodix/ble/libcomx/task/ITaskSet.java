package com.goodix.ble.libcomx.task;

import com.goodix.ble.libcomx.event.Event;

/* loaded from: classes9.dex */
public interface ITaskSet extends ITask {
    public static final int EVT_SUBTASK_FINISH = 823;
    public static final int EVT_SUBTASK_PROGRESS = 822;
    public static final int EVT_SUBTASK_START = 821;

    Event<ITask> evtSubtaskFinish();

    Event<ITask> evtSubtaskProgress();

    Event<ITask> evtSubtaskStart();
}
