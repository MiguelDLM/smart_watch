package com.kwad.components.offline.api;

import androidx.annotation.WorkerThread;

/* loaded from: classes11.dex */
public interface InitCallBack {
    @WorkerThread
    void onError(int i);

    @WorkerThread
    void onSuccess(boolean z);
}
