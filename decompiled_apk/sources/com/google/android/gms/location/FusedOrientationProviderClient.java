package com.google.android.gms.location;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public interface FusedOrientationProviderClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    @NonNull
    Task<Void> removeOrientationUpdates(@NonNull DeviceOrientationListener deviceOrientationListener);

    @NonNull
    Task<Void> requestOrientationUpdates(@NonNull DeviceOrientationRequest deviceOrientationRequest, @NonNull Executor executor, @NonNull DeviceOrientationListener deviceOrientationListener);
}
