package com.jieli.jl_rcsp.task;

/* loaded from: classes10.dex */
public interface TaskListener {
    void onBegin();

    void onCancel(int i);

    void onError(int i, String str);

    void onFinish();

    void onProgress(int i);
}
