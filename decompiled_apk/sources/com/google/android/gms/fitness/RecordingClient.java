package com.google.android.gms.fitness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzax;
import com.google.android.gms.internal.fitness.zzej;
import com.google.android.gms.tasks.Task;
import com.kuaishou.weapon.p0.g;
import java.util.List;

/* loaded from: classes9.dex */
public class RecordingClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final RecordingApi zza = new zzej();

    public RecordingClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzax.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public Task<List<Subscription>> listSubscriptions() {
        return PendingResultUtil.toTask(zza.listSubscriptions(asGoogleApiClient()), new zzt());
    }

    @NonNull
    @RequiresPermission(anyOf = {g.g, "android.permission.BODY_SENSORS", "android.permission.ACTIVITY_RECOGNITION"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    public Task<Void> subscribe(@NonNull DataSource dataSource) {
        return PendingResultUtil.toVoidTask(zza.subscribe(asGoogleApiClient(), dataSource));
    }

    @NonNull
    public Task<Void> unsubscribe(@NonNull DataSource dataSource) {
        return PendingResultUtil.toVoidTask(zza.unsubscribe(asGoogleApiClient(), dataSource));
    }

    @ShowFirstParty
    public RecordingClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzax.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public Task<List<Subscription>> listSubscriptions(@NonNull DataType dataType) {
        return PendingResultUtil.toTask(zza.listSubscriptions(asGoogleApiClient(), dataType), new zzt());
    }

    @NonNull
    @RequiresPermission(anyOf = {g.g, "android.permission.BODY_SENSORS", "android.permission.ACTIVITY_RECOGNITION"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    public Task<Void> subscribe(@NonNull DataType dataType) {
        return PendingResultUtil.toVoidTask(zza.subscribe(asGoogleApiClient(), dataType));
    }

    @NonNull
    public Task<Void> unsubscribe(@NonNull DataType dataType) {
        return PendingResultUtil.toVoidTask(zza.unsubscribe(asGoogleApiClient(), dataType));
    }

    @NonNull
    public Task<Void> unsubscribe(@NonNull Subscription subscription) {
        PendingResult<Status> unsubscribe;
        RecordingApi recordingApi = zza;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        if (subscription.getDataType() == null) {
            unsubscribe = ((zzej) recordingApi).unsubscribe(asGoogleApiClient, (DataSource) Preconditions.checkNotNull(subscription.getDataSource()));
        } else {
            unsubscribe = ((zzej) recordingApi).unsubscribe(asGoogleApiClient, (DataType) Preconditions.checkNotNull(subscription.getDataType()));
        }
        return PendingResultUtil.toVoidTask(unsubscribe);
    }
}
