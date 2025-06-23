package com.jieli.jl_rcsp.task;

/* loaded from: classes10.dex */
public interface ITask {
    void cancel(byte b);

    boolean isRun();

    void setListener(TaskListener taskListener);

    void start();
}
