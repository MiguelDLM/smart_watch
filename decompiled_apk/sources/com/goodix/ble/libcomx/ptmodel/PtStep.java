package com.goodix.ble.libcomx.ptmodel;

import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.task.ITask;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.TaskQueue;

/* loaded from: classes9.dex */
public final class PtStep extends TaskQueue {
    public static final int EVT_JUDGE_UPDATED = 728;
    private Event<Void> eventJudgeUpdated = new Event<>(this, EVT_JUDGE_UPDATED);
    private PtJudge judge;

    public PtStep(PtJudge ptJudge) {
        this.judge = ptJudge;
        setAbortOnException(true);
    }

    public <T extends ITask> T addAction(T t) {
        addTask(t);
        return t;
    }

    public Event<Void> evtJudgeUpdated() {
        return this.eventJudgeUpdated;
    }

    public PtJudge getJudge() {
        return this.judge;
    }

    @Override // com.goodix.ble.libcomx.task.TaskQueue, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        PtJudge ptJudge;
        super.onCleanup();
        ITaskResult result = getResult();
        if (result.getError() != null && (ptJudge = this.judge) != null) {
            ptJudge.exception = result.getError().getMessage();
            evtJudgeUpdated().postEvent(null);
        }
    }
}
