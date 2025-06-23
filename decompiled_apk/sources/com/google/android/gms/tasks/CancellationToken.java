package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    @NonNull
    public abstract CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener onTokenCanceledListener);
}
