package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes11.dex */
public interface k<T extends AdResultData> {
    @WorkerThread
    void a(@NonNull T t);

    @WorkerThread
    void onError(int i, String str);
}
