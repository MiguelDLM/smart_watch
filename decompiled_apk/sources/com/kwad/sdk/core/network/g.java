package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* loaded from: classes11.dex */
public interface g<R extends f, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r, int i, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r);

    @WorkerThread
    void onSuccess(@NonNull R r, @NonNull T t);
}
