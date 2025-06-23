package com.google.android.gms.fitness;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

@Deprecated
/* loaded from: classes9.dex */
public interface ConfigApi {
    @NonNull
    @Deprecated
    PendingResult<DataTypeResult> createCustomDataType(@NonNull GoogleApiClient googleApiClient, @NonNull DataTypeCreateRequest dataTypeCreateRequest);

    @NonNull
    PendingResult<Status> disableFit(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    @Deprecated
    PendingResult<DataTypeResult> readDataType(@NonNull GoogleApiClient googleApiClient, @NonNull String str);
}
