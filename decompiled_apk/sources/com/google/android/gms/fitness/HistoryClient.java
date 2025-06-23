package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.internal.fitness.zzaj;
import com.google.android.gms.internal.fitness.zzdz;
import com.google.android.gms.tasks.Task;

@Deprecated
/* loaded from: classes9.dex */
public class HistoryClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    public static final /* synthetic */ int zza = 0;
    private static final HistoryApi zzb = new zzdz();

    public HistoryClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzaj.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public Task<Void> deleteData(@NonNull DataDeleteRequest dataDeleteRequest) {
        return PendingResultUtil.toVoidTask(zzb.deleteData(asGoogleApiClient(), dataDeleteRequest));
    }

    @NonNull
    public Task<Void> insertData(@NonNull DataSet dataSet) {
        return PendingResultUtil.toVoidTask(zzb.insertData(asGoogleApiClient(), dataSet));
    }

    @NonNull
    public Task<DataSet> readDailyTotal(@NonNull DataType dataType) {
        return PendingResultUtil.toTask(zzb.readDailyTotal(asGoogleApiClient(), dataType), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.fitness.zzl
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                int i = HistoryClient.zza;
                return (DataSet) Preconditions.checkNotNull(((DailyTotalResult) result).getTotal());
            }
        });
    }

    @NonNull
    public Task<DataSet> readDailyTotalFromLocalDevice(@NonNull DataType dataType) {
        return PendingResultUtil.toTask(zzb.readDailyTotalFromLocalDevice(asGoogleApiClient(), dataType), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.fitness.zzm
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                int i = HistoryClient.zza;
                return (DataSet) Preconditions.checkNotNull(((DailyTotalResult) result).getTotal());
            }
        });
    }

    @NonNull
    public Task<DataReadResponse> readData(@NonNull DataReadRequest dataReadRequest) {
        return PendingResultUtil.toResponseTask(zzb.readData(asGoogleApiClient(), dataReadRequest), new DataReadResponse());
    }

    @NonNull
    public Task<Void> registerDataUpdateListener(@NonNull DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return PendingResultUtil.toVoidTask(zzb.registerDataUpdateListener(asGoogleApiClient(), dataUpdateListenerRegistrationRequest));
    }

    @NonNull
    public Task<Void> unregisterDataUpdateListener(@NonNull PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzb.unregisterDataUpdateListener(asGoogleApiClient(), pendingIntent));
    }

    @NonNull
    public Task<Void> updateData(@NonNull DataUpdateRequest dataUpdateRequest) {
        return PendingResultUtil.toVoidTask(zzb.updateData(asGoogleApiClient(), dataUpdateRequest));
    }

    @ShowFirstParty
    public HistoryClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzaj.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
