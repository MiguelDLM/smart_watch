package com.google.android.gms.fitness;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.kuaishou.weapon.p0.g;

@Deprecated
/* loaded from: classes9.dex */
public interface RecordingApi {
    @NonNull
    PendingResult<ListSubscriptionsResult> listSubscriptions(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    PendingResult<ListSubscriptionsResult> listSubscriptions(@NonNull GoogleApiClient googleApiClient, @NonNull DataType dataType);

    @NonNull
    @RequiresPermission(anyOf = {g.g, "android.permission.BODY_SENSORS", "android.permission.ACTIVITY_RECOGNITION"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    PendingResult<Status> subscribe(@NonNull GoogleApiClient googleApiClient, @NonNull DataSource dataSource);

    @NonNull
    @RequiresPermission(anyOf = {g.g, "android.permission.BODY_SENSORS", "android.permission.ACTIVITY_RECOGNITION"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    PendingResult<Status> subscribe(@NonNull GoogleApiClient googleApiClient, @NonNull DataType dataType);

    @NonNull
    PendingResult<Status> unsubscribe(@NonNull GoogleApiClient googleApiClient, @NonNull DataSource dataSource);

    @NonNull
    PendingResult<Status> unsubscribe(@NonNull GoogleApiClient googleApiClient, @NonNull DataType dataType);

    @NonNull
    PendingResult<Status> unsubscribe(@NonNull GoogleApiClient googleApiClient, @NonNull Subscription subscription);
}
