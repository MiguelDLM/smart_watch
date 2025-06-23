package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes11.dex */
public abstract class c extends j {
    @WorkerThread
    public abstract void a(int i, String str, boolean z);

    @WorkerThread
    public abstract void a(@NonNull AdResultData adResultData, boolean z);
}
