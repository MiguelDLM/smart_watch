package com.goodix.ble.libcomx.task;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public interface ITask extends Runnable, ITaskContext {
    public static final int EVT_FINISH = 342;
    public static final int EVT_PROGRESS = 341;
    public static final int EVT_START = 340;

    void abort();

    ITask clearListener(Object obj);

    Event<ITaskResult> evtFinished();

    Event<Integer> evtProgress();

    Event<Void> evtStart();

    ILogger getLogger();

    String getName();

    <T> T getOutput(String str);

    <T> T getPreviousTask();

    int getProgress();

    ITaskResult getResult();

    boolean isFinished();

    boolean isStarted();

    ITask setDebounceProgressEvent(boolean z);

    ITask setDebug(boolean z);

    ITask setExecutor(Executor executor);

    ITask setLogger(ILogger iLogger);

    ITask setName(String str);

    void start(ITaskContext iTaskContext, ITask iTask);
}
