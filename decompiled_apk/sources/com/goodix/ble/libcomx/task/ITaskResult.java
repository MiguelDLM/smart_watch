package com.goodix.ble.libcomx.task;

/* loaded from: classes9.dex */
public interface ITaskResult {
    public static final int CODE_ABORT = -2;
    public static final int CODE_DONE = 0;
    public static final int CODE_ERROR = -1;
    public static final int CODE_SKIP = -4;
    public static final int CODE_TIMEOUT = -3;

    int getCode();

    TaskError getError();

    ITask getTask();
}
