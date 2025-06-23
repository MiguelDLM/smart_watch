package com.tenmeter.smlibrary.utils.launcher;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

/* loaded from: classes13.dex */
public interface Launcher<I, O> {
    @Nullable
    ActivityResultLauncher<I> getLauncher();

    void launch(I i, ActivityResultCallback<O> activityResultCallback);

    void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat, ActivityResultCallback<O> activityResultCallback);
}
